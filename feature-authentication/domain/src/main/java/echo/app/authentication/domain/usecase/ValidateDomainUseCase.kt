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
package echo.app.authentication.domain.usecase

import arrow.core.Either
import arrow.core.raise.either
import arrow.core.raise.ensure
import echo.app.authentication.domain.model.UrlValidationError
import echo.app.domain.inputstate.InputStateError

class ValidateDomainUseCase {
    operator fun invoke(domain: String): Either<InputStateError, Unit> = either {
        val urlRegex = Regex("^(https?://)?(www\\.)?([\\w-]+\\.)+[\\w-]+/?$")
        ensure(domain.isNotEmpty()) { UrlValidationError.EmptyDomain }
        ensure(urlRegex.matches(domain)) { UrlValidationError.InvalidDomainAddress }
    }
}
