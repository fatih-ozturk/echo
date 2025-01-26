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

import echo.app.network.model.account.AccountResponse
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class StatusResponse(
    @SerialName("id") val id: String,
    @SerialName("created_at") val createdAt: String?,
    @SerialName("in_reply_to_id") val inReplyToId: String?,
    @SerialName("in_reply_to_account_id") val inReplyToAccountId: String?,
    @SerialName("sensitive") val sensitive: Boolean?,
    @SerialName("spoiler_text") val spoilerText: String?,
    @SerialName("visibility") val visibility: String?,
    @SerialName("language") val language: String?,
    @SerialName("uri") val uri: String?,
    @SerialName("url") val url: String?,
    @SerialName("replies_count") val repliesCount: Int?,
    @SerialName("reblogs_count") val reblogsCount: Int?,
    @SerialName("favourites_count") val favouritesCount: Int?,
    @SerialName("edited_at") val editedAt: String?,
    @SerialName("favourited") val favourited: Boolean?,
    @SerialName("reblogged") val reblogged: Boolean?,
    @SerialName("muted") val muted: Boolean?,
    @SerialName("bookmarked") val bookmarked: Boolean?,
    @SerialName("content") val content: String?,
    // @SerialName("filtered") val filtered: List<AnyResponse>,
    @SerialName("reblog") val reblog: StatusResponse?,
    @SerialName("account") val account: AccountResponse,
    // @SerialName("media_attachments") val mediaAttachments: List<AnyResponse>,
    // @SerialName("mentions") val mentions: List<AnyResponse>,
    // @SerialName("tags") val tags: List<AnyResponse>,
    // @SerialName("emojis") val emojis: List<AnyResponse>,
    @SerialName("card") val card: CardResponse?
    // @SerialName("poll") val poll: AnyResponse?
)
