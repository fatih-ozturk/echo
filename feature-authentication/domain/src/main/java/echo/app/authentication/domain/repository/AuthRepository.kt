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
package echo.app.authentication.domain.repository

import arrow.core.Either
import echo.app.authentication.domain.model.ApplicationCredentials
import echo.app.domain.error.DataError

interface AuthRepository {
    suspend fun registerApp(domain: String): Either<DataError.Remote, ApplicationCredentials>
    suspend fun authenticateWithCode(
        code: String,
        credentials: ApplicationCredentials
    ): Either<DataError.Remote, Unit>
}
