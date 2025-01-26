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

import echo.app.network.MastodonWebConfig
import echo.app.network.core.getByPaths
import echo.app.network.core.json
import echo.app.network.core.parameterCategory
import echo.app.network.core.parameterLanguage
import echo.app.network.model.MastodonCategoryResponse
import echo.app.network.model.MastodonLanguageResponse
import echo.app.network.model.MastodonServerResponse
import io.ktor.client.HttpClient
import io.ktor.client.request.host

class MastodonApi internal constructor(
    private val client: HttpClient,
) {
    suspend fun getMastodonCategories(language: String?): List<MastodonCategoryResponse> =
        client.getByPaths("categories") {
            host = MastodonWebConfig.MASTODON_HOST
            json()
            parameterLanguage(language)
        }

    suspend fun getMastodonServers(
        language: String?,
        category: String?,
    ): List<MastodonServerResponse> =
        client.getByPaths("servers") {
            host = MastodonWebConfig.MASTODON_HOST
            json()
            parameterLanguage(language)
            parameterCategory(category)
        }

    suspend fun getMastodonLanguages(): List<MastodonLanguageResponse> =
        client.getByPaths("languages") {
            host = MastodonWebConfig.MASTODON_HOST
            json()
        }
}
