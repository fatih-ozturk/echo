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
import echo.app.account.api.SessionRepository
import echo.app.account.api.model.Session
import echo.app.account.implementation.datasource.local.AccountLocalDataSource
import echo.app.account.implementation.datasource.local.SessionLocalDataSource
import echo.app.account.implementation.mapper.toDomainModel
import echo.app.domain.error.DataError
import echo.app.securitycrypto.api.KeyStoreCryptoManager
import javax.inject.Inject

class SessionRepositoryImpl @Inject constructor(
    private val sessionLocalDataSource: SessionLocalDataSource,
    private val accountLocalDataSource: AccountLocalDataSource,
    private val keyStoreCryptoManager: KeyStoreCryptoManager,
) : SessionRepository {
    override suspend fun getPrimarySession(): Either<DataError.Local, Session?> = either {
        val primaryAccount = accountLocalDataSource.getPrimaryAccount()
        val session = sessionLocalDataSource.getSessionById(primaryAccount?.sessionId ?: "")
        if (session == null) raise(DataError.Local.NoEntity("No primary session found"))
        session.toDomainModel(keyStoreCryptoManager)
    }
}
