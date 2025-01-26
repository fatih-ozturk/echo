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
package echo.app.network.core

import echo.app.network.MastodonClientConfig
import echo.app.network.model.MastodonErrorResponse
import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig
import io.ktor.client.call.HttpClientCall
import io.ktor.client.plugins.ClientRequestException
import io.ktor.client.plugins.HttpRequestRetry
import io.ktor.client.plugins.HttpResponseValidator
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.auth.Auth
import io.ktor.client.plugins.auth.providers.BearerTokens
import io.ktor.client.plugins.auth.providers.bearer
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.statement.HttpResponse
import io.ktor.client.statement.bodyAsText
import io.ktor.client.statement.request
import io.ktor.http.Headers
import io.ktor.http.HttpProtocolVersion
import io.ktor.http.HttpStatusCode
import io.ktor.http.URLProtocol
import io.ktor.http.path
import io.ktor.serialization.kotlinx.json.json
import io.ktor.util.date.GMTDate
import io.ktor.utils.io.ByteReadChannel
import io.ktor.utils.io.InternalAPI
import kotlin.coroutines.CoroutineContext
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json

internal object HttpClientFactory {
    fun buildHttpClient(config: MastodonClientConfig): HttpClient {
        val defaultConfig: HttpClientConfig<*>.() -> Unit = {
            val json = Json {
                ignoreUnknownKeys = true
                prettyPrint = true
                isLenient = true
            }

            defaultRequest {
                url {
                    val serverHost = config.mastodonAuthCredentials?.loadDomainProvider?.invoke()
                    protocol = URLProtocol.HTTPS
                    host = serverHost.orEmpty()
                    path("/api/v1/")
                }
            }

            install(ContentNegotiation) {
                json(json)
            }

            install(Auth) {
                bearer {
                    loadTokens {
                        config.mastodonAuthCredentials?.loadTokensProvider?.invoke()?.let {
                            BearerTokens(it, "")
                        }
                    }

                    sendWithoutRequest { true }
                }
            }

            expectSuccess = true
            HttpResponseValidator {
                validateResponse { response ->
                    if (response.request.url.host.isEmpty()) {
                        throw ClientRequestException(
                            response.asUnauthorizedResponse(),
                            "Unauthorized request."
                        )
                    }
                }
                handleResponseExceptionWithRequest { exception, request ->
                    val clientException =
                        exception as? ClientRequestException ?: return@handleResponseExceptionWithRequest

                    throw try {
                        val jsonString = clientException.response.bodyAsText()
                        val mastodonErrorResponse = json.decodeFromString<MastodonErrorResponse>(jsonString)
                        MastodonException(mastodonErrorResponse, exception)
                    } catch (serializationException: SerializationException) {
                        serializationException
                    }
                }
            }

            install(HttpRequestRetry) {
                exponentialDelay()
                retryIf(maxRetries = 5) { _, response ->
                    response.status.value == HttpStatusCode.NonAuthoritativeInformation.value
                }
                retryOnServerErrors(maxRetries = 3)
            }

            install(HttpTimeout) {
                requestTimeoutMillis = 60_000
                connectTimeoutMillis = 60_000
                socketTimeoutMillis = 60_000
            }

            config.httpClientConfigBlock?.invoke(this)
        }

        return config.httpClientBuilder?.invoke()?.config(defaultConfig)
            ?: HttpClient(defaultConfig)
    }

    private fun HttpResponse.asUnauthorizedResponse(): HttpResponse {
        val response = this
        return object : HttpResponse() {
            override val call: HttpClientCall
                get() = response.call

            @InternalAPI
            override val rawContent: ByteReadChannel
                get() = response.rawContent
            override val coroutineContext: CoroutineContext
                get() = response.coroutineContext
            override val headers: Headers
                get() = response.headers
            override val requestTime: GMTDate
                get() = response.requestTime
            override val responseTime: GMTDate
                get() = response.responseTime
            override val status: HttpStatusCode
                get() = HttpStatusCode.Unauthorized
            override val version: HttpProtocolVersion
                get() = response.version
        }
    }
}
