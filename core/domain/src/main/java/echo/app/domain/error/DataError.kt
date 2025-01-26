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
package echo.app.domain.error

sealed interface DataError {

    sealed interface Local : DataError {
        val message: String

        data class Unknown(
            override val message: String
        ) : Local
    }

    sealed interface Remote : DataError {
        val message: String

        data class Mastodon(
            override val message: String
        ) : Remote

        data class Http(
            override val message: String
        ) : Remote

        data class Unknown(
            override val message: String
        ) : Remote
    }
}
