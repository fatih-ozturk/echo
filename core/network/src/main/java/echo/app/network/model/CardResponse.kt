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
package echo.app.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CardResponse(
    @SerialName("url") val url: String?,
    @SerialName("title") val title: String?,
    @SerialName("description") val description: String?,
    @SerialName("language") val language: String?,
    @SerialName("type") val type: String?,
    @SerialName("author_name") val authorName: String?,
    @SerialName("author_url") val authorUrl: String?,
    @SerialName("provider_name") val providerName: String?,
    @SerialName("provider_url") val providerUrl: String?,
    @SerialName("html") val html: String?,
    @SerialName("width") val width: Int?,
    @SerialName("height") val height: Int?,
    @SerialName("image") val image: String?,
    @SerialName("image_description") val imageDescription: String?,
    @SerialName("embed_url") val embedUrl: String?,
    @SerialName("blurhash") val blurhash: String?,
    @SerialName("published_at") val publishedAt: String?
)
