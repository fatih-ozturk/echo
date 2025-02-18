/*
 * Copyright 2025 Fatih OZTURK
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package echo.app.account.implementation.repository

import arrow.core.Either
import arrow.core.raise.either
import echo.app.account.api.AccountRepository
import echo.app.account.api.model.Session
import echo.app.account.implementation.database.AccountDatabase
import echo.app.account.implementation.datasource.local.AccountLocalDataSource
import echo.app.account.implementation.datasource.local.SessionLocalDataSource
import echo.app.account.implementation.datasource.remote.AccountRemoteDataSource
import echo.app.account.implementation.entity.AccountEntity
import echo.app.account.implementation.entity.SessionEntity
import echo.app.account.implementation.mapper.toDataModel
import echo.app.account.implementation.mapper.toDomainModel
import echo.app.data.util.toDataError
import echo.app.domain.error.DataError
import echo.app.domain.model.Account
import echo.app.network.model.account.AccountResponse
import echo.app.securitycrypto.api.KeyStoreCryptoManager
import java.util.UUID
import javax.inject.Inject

class AccountRepositoryImpl @Inject constructor(
    private val accountRemoteDataSource: AccountRemoteDataSource,
    private val accountLocalDataSource: AccountLocalDataSource,
    private val sessionLocalDataSource: SessionLocalDataSource,
    private val accountDatabase: AccountDatabase,
    private val keyStoreCryptoManager: KeyStoreCryptoManager
) : AccountRepository {

    override suspend fun getAccount(accountId: String): Either<DataError.Remote, Account> = either {
        accountRemoteDataSource.getAccount(accountId = accountId).toDataError()
            .map(AccountResponse::toDataModel).bind()
    }

    override suspend fun verifyAccountCredentials(
        domain: String, accessToken: String
    ): Either<DataError.Remote, Account> = either {
        accountRemoteDataSource.verifyAccountCredentials(
            domain = domain, accessToken = accessToken
        ).toDataError().map(AccountResponse::toDataModel).bind()
    }

    override suspend fun getPrimaryAccount(): Either<DataError.Local, Account?> = either {
        val primaryAccount = accountLocalDataSource.getPrimaryAccount()
        primaryAccount?.toDomainModel()
            ?: raise(DataError.Local.NoEntity("No primary account found"))
    }

    override suspend fun upsertAccountWithSession(
        account: Account,
        session: Session
    ): Either<DataError.Local, Unit> = either {
        val encryptedAccessToken = keyStoreCryptoManager.encrypt(session.accessToken)
        val sessionEntity = SessionEntity(
            sessionId = UUID.randomUUID().toString(),
            accessToken = encryptedAccessToken,
            userId = account.accountId,
            domain = session.domain
        )
        val accountEntity = AccountEntity(
            userId = account.accountId,
            sessionId = null,
            username = account.username,
            primaryAt = System.currentTimeMillis()
        )

        accountDatabase.inTransaction {
            accountLocalDataSource.upsert(accountEntity)
        }

        accountDatabase.inTransaction {
            sessionLocalDataSource.upsert(sessionEntity)
            accountLocalDataSource.addSession(accountEntity.userId, sessionEntity.sessionId)
        }
    }
}
