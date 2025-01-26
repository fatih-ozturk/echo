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
package echo.app.authmanager.data.repository

import arrow.core.Either
import arrow.core.raise.either
import echo.app.authmanager.data.db.AccountDatabase
import echo.app.authmanager.data.ds.local.AccountLocalDataSource
import echo.app.authmanager.data.ds.local.SessionLocalDataSource
import echo.app.authmanager.data.entity.AccountEntity
import echo.app.authmanager.data.entity.SessionEntity
import echo.app.authmanager.data.mapper.toDomainModel
import echo.app.authmanager.domain.AuthManager
import echo.app.authmanager.domain.model.Account
import echo.app.authmanager.domain.model.Session
import echo.app.domain.error.DataError
import java.util.UUID
import javax.inject.Inject

class AuthManagerImpl @Inject constructor(
    private val accountLocalDataSource: AccountLocalDataSource,
    private val sessionLocalDataSource: SessionLocalDataSource,
    private val accountDatabase: AccountDatabase
) : AuthManager {

    override suspend fun getPrimaryAccount(): Account? {
        return accountLocalDataSource.getPrimaryAccount()?.toDomainModel()
    }

    override suspend fun upsertAccountWithSession(
        account: Account,
        session: Session
    ): Either<DataError.Local, Unit> = either {

        val sessionEntity = SessionEntity(
            sessionId = UUID.randomUUID().toString(),
            accessToken = session.accessToken,
            userId = account.accountId,
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
