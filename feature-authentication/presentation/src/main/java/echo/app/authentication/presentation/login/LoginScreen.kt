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
package echo.app.authentication.presentation.login

import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import echo.app.authentication.presentation.R
import echo.app.authentication.presentation.login.auth.model.LoginActivityResultContract
import echo.app.chroma.component.button.ChromaButtons
import echo.app.chroma.component.text.ChromaText
import echo.app.chroma.component.textfield.ChromaTextField
import echo.app.chroma.tokens.ChromaTheme
import echo.app.core.presentation.EventsEffect
import echo.app.core.presentation.components.ChromaBasicAlertDialog
import echo.app.core.presentation.components.ChromaLoadingDialog

@Composable
fun LoginScreen(
    viewModel: LoginViewModel = hiltViewModel(),
    navigateToHome: () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    val loginLauncher = rememberLauncherForActivityResult(
        contract = LoginActivityResultContract,
        onResult = {
            viewModel.trySendAction(LoginAction.HandleLoginResult(it))
        }
    )

    EventsEffect(viewModel) { effect ->
        when (effect) {
            is LoginEvent.LaunchAuthorizationActivity -> {
                loginLauncher.launch(effect.applicationCredentials)
            }

            LoginEvent.NavigateToHome -> navigateToHome()
        }
    }

    LoginScreen(
        state = state,
        actions = LoginScreen.Actions(
            onLoginClicked = {
                viewModel.trySendAction(LoginAction.OnLoginClicked)
            },
            onDomainChanged = {
                viewModel.trySendAction(LoginAction.OnDomainChanged(it))
            },
            onDialogDismiss = {
                viewModel.trySendAction(LoginAction.DialogDismiss)
            }
        )
    )
}

@Composable
private fun LoginScreen(
    state: LoginState,
    actions: LoginScreen.Actions
) {
    val focusManager = LocalFocusManager.current

    LoginScreenDialogs(
        dialogState = state.dialogState,
        onDismissRequest = {
            actions.onDialogDismiss()
        }
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .clickable(
                interactionSource = remember { MutableInteractionSource() },
                indication = null,
                onClick = {
                    focusManager.clearFocus(true)
                }
            )
            .background(ChromaTheme.colors.bgPrimary)
    ) {
        Column(
            modifier = Modifier
                .padding(horizontal = ChromaTheme.spacing.spacingXl)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .padding(top = ChromaTheme.spacing.spacing4Xl)
                    .size(96.dp)
            )
            ChromaText(
                modifier = Modifier
                    .padding(top = ChromaTheme.spacing.spacing4Xl),
                text = stringResource(R.string.welcome_page_title),
                textAlign = TextAlign.Center,
                style = ChromaTheme.typography.displayXs,
                fontWeight = FontWeight.Bold,
                color = ChromaTheme.colors.textPrimary
            )
            ChromaText(
                modifier = Modifier
                    .padding(top = ChromaTheme.spacing.spacingMd),
                text = stringResource(R.string.welcome_page_description),
                textAlign = TextAlign.Center,
                style = ChromaTheme.typography.textMd,
                color = ChromaTheme.colors.textTertiary
            )
            ChromaTextField(
                modifier = Modifier.padding(top = ChromaTheme.spacing.spacing4Xl),
                value = state.domainInputState.value,
                onValueChange = { value ->
                    actions.onDomainChanged(value)
                },
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Uri
                ),
                keyboardActions = KeyboardActions(
                    onDone = {
                        actions.onLoginClicked()
                    }
                ),
                isError = state.domainInputState.isValid,
                label = stringResource(R.string.welcome_server_url_label),
                placeholder = stringResource(R.string.welcome_server_url_placeholder),
                hint = state.domainInputState.error?.toString()
            )
            ChromaButtons.Primary(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = ChromaTheme.spacing.spacing3Xl),
                text = stringResource(R.string.welcome_server_login_button_text),
                onClick = {
                    actions.onLoginClicked()
                }
            )
        }
    }
}

@Composable
fun LoginScreenDialogs(
    dialogState: LoginState.DialogState?,
    onDismissRequest: () -> Unit
) {
    when (dialogState) {
        is LoginState.DialogState.Error -> {
            ChromaBasicAlertDialog(
                message = dialogState.message,
                onDismissRequest = onDismissRequest
            )
        }

        LoginState.DialogState.Loading -> {
            ChromaLoadingDialog()
        }

        else -> Unit
    }
}

private object LoginScreen {

    data class Actions(
        val onLoginClicked: () -> Unit,
        val onDomainChanged: (domain: String) -> Unit,
        val onDialogDismiss: () -> Unit
    ) {
        companion object {
            val EMPTY = Actions(
                onLoginClicked = {},
                onDomainChanged = {},
                onDialogDismiss = {},
            )
        }
    }
}

@Preview
@Composable
private fun LoginScreenPreview() {
    ChromaTheme {
        LoginScreen(
            state = LoginState(),
            actions = LoginScreen.Actions.EMPTY
        )
    }
}
