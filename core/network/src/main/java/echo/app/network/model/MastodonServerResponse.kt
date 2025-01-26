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
data class MastodonServerResponse(
    @SerialName("domain") val domain: String,
    @SerialName("languages") val languages: List<String?>,
    @SerialName("blurhash") val blurhash: String?,
    @SerialName("approval_required") val approvalRequired: Boolean,
    @SerialName("description") val description: String,
    @SerialName("language") val language: String,
    @SerialName("version") val version: String,
    @SerialName("last_week_users") val lastWeekUsers: Int,
    @SerialName("proxied_thumbnail") val proxiedThumbnail: String,
    @SerialName("categories") val categories: List<String?>,
    @SerialName("region") val region: String?,
    @SerialName("total_users") val totalUsers: Int,
    @SerialName("category") val category: String
)
