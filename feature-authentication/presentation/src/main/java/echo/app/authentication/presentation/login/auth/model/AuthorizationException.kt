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
package echo.app.authentication.presentation.login.auth.model

import android.content.Intent
import arrow.core.Option
import arrow.core.toOption

data class AuthorizationException(
    val error: Option<String>
) {
    companion object {
        fun fromIntent(intent: Intent?): AuthorizationException {
            val error = intent?.data?.getQueryParameter("error").toOption()
            return AuthorizationException(error = error)
        }
    }
}
