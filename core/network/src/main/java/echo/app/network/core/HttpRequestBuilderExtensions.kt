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

import io.ktor.client.request.HttpRequestBuilder
import io.ktor.client.request.parameter
import io.ktor.http.ContentType
import io.ktor.http.contentType

internal fun HttpRequestBuilder.json() {
    contentType(ContentType.Application.Json)
}

internal fun HttpRequestBuilder.parameterLanguage(language: String?) {
    language?.let { parameter("language", it) }
}

internal fun HttpRequestBuilder.parameterCategory(category: String?) {
    category?.let { parameter("category", it) }
}

internal fun HttpRequestBuilder.parameterMinID(minId: String?) {
    minId?.let { parameter("min_id", it) }
}

internal fun HttpRequestBuilder.parameterSinceId(sinceId: String?) {
    sinceId?.let { parameter("since_id", it) }
}

internal fun HttpRequestBuilder.parameterMaxID(maxId: String?) {
    maxId?.let { parameter("max_id", it) }
}

internal fun HttpRequestBuilder.parameterLimit(limit: Int?) {
    limit?.let { parameter("limit", it) }
}
