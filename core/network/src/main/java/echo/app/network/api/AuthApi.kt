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
package echo.app.network.api

import arrow.core.Either
import echo.app.network.MastodonWebConfig
import echo.app.network.model.AccessTokenResponse
import echo.app.network.model.CredentialsResponse
import echo.app.network.utils.ApiError
import echo.app.network.utils.safeRequest
import io.ktor.client.HttpClient
import io.ktor.client.request.forms.FormDataContent
import io.ktor.client.request.setBody
import io.ktor.http.HttpMethod
import io.ktor.http.URLProtocol
import io.ktor.http.parameters
import io.ktor.http.path

class AuthApi(
    private val client: HttpClient,
) {
    suspend fun registerApp(domain: String): Either<ApiError, CredentialsResponse> =
        client
            .safeRequest<CredentialsResponse> {
                method = HttpMethod.Post
                url {
                    protocol = URLProtocol.HTTPS
                    host = domain
                    path("/api/v1/apps")
                }
                setBody(
                    FormDataContent(
                        parameters {
                            append("client_name", MastodonWebConfig.APP_NAME)
                            append("redirect_uris", MastodonWebConfig.REDIRECT_URI)
                            append("scopes", MastodonWebConfig.AUTH_SCOPES)
                        },
                    ),
                )
            }
            .map { it.copy(scopes = MastodonWebConfig.AUTH_SCOPES) }

    suspend fun fetchOAuthToken(
        domain: String,
        clientId: String,
        clientSecret: String,
        redirectUri: String,
        code: String,
        grantType: String,
    ): Either<ApiError, AccessTokenResponse> =
        client.safeRequest {
            method = HttpMethod.Post
            url {
                protocol = URLProtocol.HTTPS
                host = domain
                path("oauth/token")
            }
            setBody(
                FormDataContent(
                    parameters {
                        append("client_id", clientId)
                        append("client_secret", clientSecret)
                        append("redirect_uri", redirectUri)
                        append("code", code)
                        append("grant_type", grantType)
                    },
                ),
            )
        }
}
