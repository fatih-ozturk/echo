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
package echo.app.network.utils

import echo.app.network.model.MastodonException
import io.ktor.client.plugins.ClientRequestException

internal fun Throwable.toNetworkError(): ApiError {
    return when (this) {
        is MastodonException -> ApiError.MastodonError(
            errorResponse.statusCode,
            errorResponse.message,
        )

        is ClientRequestException -> ApiError.HttpError(
            code = response.status.value,
            message = response.toString(),
            throwable = this,
        )

        else -> ApiError.UnknownError(
            message = message.orEmpty(),
            throwable = this,
        )
    }
}
