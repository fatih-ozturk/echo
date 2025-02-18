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

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract
import arrow.core.Either
import echo.app.authentication.domain.model.ApplicationCredentials
import echo.app.authentication.presentation.login.auth.AuthorizationManagementActivity

internal object LoginActivityResultContract :
    ActivityResultContract<ApplicationCredentials, Either<AuthorizationException, AuthorizationResponse>>() {

    override fun createIntent(context: Context, input: ApplicationCredentials): Intent {
        return AuthorizationManagementActivity.createIntent(context, input)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): Either<AuthorizationException, AuthorizationResponse> {
        val response = AuthorizationResponse.fromIntent(intent)
        val exception = AuthorizationException.fromIntent(intent)

        return when {
            exception.error.isSome() -> Either.Left(exception)
            else -> Either.Right(response)
        }
    }
}
