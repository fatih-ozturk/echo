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
package echo.app.authentication.data.ds.remote

import arrow.core.Either
import echo.app.authentication.domain.model.ApplicationCredentials
import echo.app.network.Mastodon
import echo.app.network.api.AuthApi
import echo.app.network.model.AccessTokenResponse
import echo.app.network.utils.ApiError
import javax.inject.Inject

class AuthenticationRemoteDataSourceImpl @Inject constructor(
    private val mastodon: Mastodon
) : AuthenticationRemoteDataSource {

    private val authApi: AuthApi
        get() = mastodon.authApi

    override suspend fun registerApp(domain: String): Either<ApiError, ApplicationCredentials> {
        return authApi.registerApp(domain = domain).map { registeredApp ->
            ApplicationCredentials(
                domain = domain,
                clientId = registeredApp.clientId,
                clientSecret = registeredApp.clientSecret,
                redirectUri = registeredApp.redirectUri,
                scope = registeredApp.scopes
            )
        }
    }

    override suspend fun fetchOAuthToken(
        code: String,
        credentials: ApplicationCredentials
    ): Either<ApiError, AccessTokenResponse> {
        return authApi.fetchOAuthToken(
            domain = credentials.domain,
            clientId = credentials.clientId,
            clientSecret = credentials.clientSecret,
            redirectUri = credentials.redirectUri,
            code = code,
            grantType = GRANT_TYPE_AUTHORIZATION_CODE
        )
    }

    companion object {
        private const val GRANT_TYPE_AUTHORIZATION_CODE = "authorization_code"
    }

}


