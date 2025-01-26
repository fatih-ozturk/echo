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
package echo.app.authentication.presentation.login.auth

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.net.toUri
import echo.app.authentication.domain.model.ApplicationCredentials
import okhttp3.HttpUrl
import timber.log.Timber

internal class AuthorizationManagementActivity : Activity() {
    private var isAuthStarted = false

    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        isAuthStarted = savedInstanceState.getBoolean(KEY_AUTH_STARTED, false)
    }

    override fun onNewIntent(intent: Intent?) {
        super.onNewIntent(intent)
        setIntent(intent)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        outState.putBoolean(KEY_AUTH_STARTED, isAuthStarted)
        super.onSaveInstanceState(outState)
    }

    override fun onResume() {
        super.onResume()

        if (!isAuthStarted) {
            runCatching {
                startAuth()
                isAuthStarted = true
            }.onFailure { exception ->
                Timber.e(exception)
                setResult(RESULT_CANCELED)
                finish()
            }
            return
        }

        setResult(if (intent?.data != null) RESULT_OK else RESULT_CANCELED, intent)
        finish()
    }

    private fun startAuth() {
        val input: ApplicationCredentials = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra(KEY_AUTH_REQUEST, ApplicationCredentials::class.java)
        } else {
            intent.getSerializableExtra(KEY_AUTH_REQUEST) as ApplicationCredentials?
        } ?: run {
            setResult(RESULT_CANCELED)
            finish()
            return
        }

        val uri = HttpUrl.Builder()
            .scheme("https")
            .host(input.domain)
            .addPathSegments("oauth/authorize")
            .addEncodedQueryParameter("client_id", input.clientId)
            .addEncodedQueryParameter("redirect_uri", input.redirectUri)
            .addEncodedQueryParameter("response_type", "code")
            .addEncodedQueryParameter("scope", input.scope)
            .build()
            .toString()
            .toUri()

        CustomTabsIntent.Builder()
            .setShowTitle(true)
            .build()
            .apply {
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
                launchUrl(this@AuthorizationManagementActivity, uri)
            }
    }

    companion object {
        private const val KEY_AUTH_REQUEST = "authRequest"
        private const val KEY_AUTH_STARTED = "authStarted"

        fun createIntent(
            context: Context,
            applicationCredentials: ApplicationCredentials
        ) = Intent(context, AuthorizationManagementActivity::class.java).apply {
            putExtra(KEY_AUTH_REQUEST, applicationCredentials)
        }
    }
}
