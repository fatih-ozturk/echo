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

sealed class ApiError {

    data class MastodonError(
        val code: Int,
        val message: String,
    ) : ApiError()

    data class HttpError(
        val code: Int,
        val message: String,
        val throwable: Throwable?,
    ) : ApiError()

    data class UnknownError(
        val message: String,
        val throwable: Throwable?,
    ) : ApiError()
}
