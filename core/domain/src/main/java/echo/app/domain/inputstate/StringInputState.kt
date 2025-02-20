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
package echo.app.domain.inputstate

data class StringInputState(
    override val value: String = "",
    override val isValid: Boolean = false,
    override val error: InputStateError? = null
) : InputState<String> {

    override fun update(value: String): StringInputState = copy(
        value = value,
        isValid = false,
        error = null
    )

    override fun update(error: InputStateError): StringInputState = copy(
        isValid = false,
        error = error
    )

    override fun update(validationResult: ValidationResult): StringInputState =
        when (validationResult) {
            is ValidationResult.Error -> copy(
                error = validationResult.inputStateError,
                isValid = false
            )

            ValidationResult.Success -> copy(
                error = null,
                isValid = true
            )
        }
}
