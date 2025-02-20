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
package echo.app.authentication.presentation.login.mapper

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import echo.app.authentication.domain.model.DomainValidationError
import echo.app.authentication.presentation.R
import echo.app.domain.inputstate.InputStateError

@Composable
fun InputStateError.toErrorMessage(): String {
    val resources = LocalContext.current.resources
    return when(this) {
        DomainValidationError.EmptyDomain -> resources.getString(R.string.login_domain_empty_error)
        DomainValidationError.InvalidDomainAddress -> resources.getString(R.string.login_domain_invalid_error)
        else -> resources.getString(R.string.login_domain_unknown_error)
    }
}
