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
package echo.app.authentication.data.repository

import arrow.core.Either
import arrow.core.raise.either
import echo.app.authentication.data.ds.remote.AccountRemoteDataSource
import echo.app.authentication.data.ds.remote.AuthenticationRemoteDataSource
import echo.app.authentication.domain.model.ApplicationCredentials
import echo.app.authentication.domain.repository.AuthRepository
import echo.app.authmanager.domain.AuthManager
import echo.app.authmanager.domain.model.Account
import echo.app.authmanager.domain.model.Session
import echo.app.data.util.toDataError
import echo.app.domain.error.DataError
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authenticationRemoteDataSource: AuthenticationRemoteDataSource,
    private val accountRemoteDataSource: AccountRemoteDataSource,
    private val authManager: AuthManager,
) : AuthRepository {

    override suspend fun registerApp(
        domain: String
    ): Either<DataError.Remote, ApplicationCredentials> = either {
        authenticationRemoteDataSource
            .registerApp(domain = domain)
            .toDataError()
            .map { registeredApp ->
                val applicationCredentials = ApplicationCredentials(
                    domain = domain,
                    clientId = registeredApp.clientId,
                    clientSecret = registeredApp.clientSecret,
                    redirectUri = registeredApp.redirectUri,
                    scope = registeredApp.scope,
                )
                return@map applicationCredentials
            }.bind()
    }

    override suspend fun authenticateWithCode(
        code: String,
        credentials: ApplicationCredentials
    ): Either<DataError.Remote, Unit> = either {
        val accessTokenResponse = authenticationRemoteDataSource.fetchOAuthToken(
            code = code,
            credentials = credentials
        ).toDataError().bind()

        val currentAccount = accountRemoteDataSource.verifyAccountCredentials(
            domain = credentials.domain,
            accessToken = accessTokenResponse.accessToken
        ).toDataError().bind()

        val session = Session(
            accessToken = accessTokenResponse.accessToken,
        )

        val account = Account(
            accountId = currentAccount.id,
            username = currentAccount.username
        )

        authManager.upsertAccountWithSession(account, session)
    }
}
