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
package echo.app.network.model.account

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class AccountResponse(
    @SerialName("id") val id: String,
    @SerialName("username") val username: String,
    @SerialName("acct") val acct: String,
    @SerialName("display_name") val displayName: String,
    @SerialName("locked") val locked: Boolean,
    @SerialName("bot") val bot: Boolean,
    @SerialName("discoverable") val discoverable: Boolean?,
    @SerialName("group") val group: Boolean,
    @SerialName("created_at") val createdAt: String?,
    @SerialName("note") val note: String,
    @SerialName("url") val url: String,
    @SerialName("uri") val uri: String,
    @SerialName("avatar") val avatar: String,
    @SerialName("avatar_static") val avatarStatic: String,
    @SerialName("header") val header: String,
    @SerialName("header_static") val headerStatic: String,
    @SerialName("followers_count") val followersCount: Int,
    @SerialName("following_count") val followingCount: Int,
    @SerialName("statuses_count") val statusesCount: Int,
    @SerialName("last_status_at") val lastStatusAt: String?
//    @SerialName("noindex") val noIndex: Boolean?,
//    @SerialName("source") val source: SourceResponse? = null,
//    @SerialName("emojis") val emojis: List<EmojiResponse>,
//    @SerialName("roles") val roles: List<RoleResponse>,
//    @SerialName("fields") val fields: List<FieldResponse>,
)
