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

import androidx.lifecycle.viewModelScope
import arrow.core.Either
import arrow.core.getOrElse
import dagger.hilt.android.lifecycle.HiltViewModel
import echo.app.authentication.domain.model.ApplicationCredentials
import echo.app.authentication.domain.repository.AuthRepository
import echo.app.authentication.domain.usecase.ValidateDomainUseCase
import echo.app.authentication.presentation.login.auth.model.AuthorizationException
import echo.app.authentication.presentation.login.auth.model.AuthorizationResponse
import echo.app.core.presentation.BaseViewModel
import echo.app.domain.inputstate.StringInputState
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val validateDomainUseCase: ValidateDomainUseCase, private val authRepository: AuthRepository
) : BaseViewModel<LoginState, LoginEvent, LoginAction>(
    initialState = LoginState()
) {
    override fun handleAction(action: LoginAction) {
        when (action) {
            is LoginAction.OnDomainChanged -> onDomainChanged(action.domain)
            LoginAction.OnLoginClicked -> onLoginClicked()
            is LoginAction.HandleLoginResult -> handleLoginResult(action.loginResult)
            LoginAction.DialogDismiss -> dialogDismiss()
        }
    }

    private fun handleLoginResult(
        loginResult: Either<AuthorizationException, AuthorizationResponse>
    ) {
        loginResult.onRight {
            it.code
                .onSome { code ->
                    authenticateWithCode(code)
                }
                .onNone {
                    showDialogError("Code is empty")
                    Timber.e("Code is empty")
                }
        }.onLeft {
            showDialogError(it.error.getOrElse { "Authorization cancelled" })
            Timber.e(it.error.getOrNull())
        }
    }

    private fun authenticateWithCode(code: String) = viewModelScope.launch {
        val currentApplicationCredentials = state.value.applicationCredentials ?: return@launch

        authRepository.authenticateWithCode(
            code = code,
            credentials = currentApplicationCredentials
        ).onRight {
            sendEvent(LoginEvent.NavigateToHome)
            Timber.e("Logged In")
        }.onLeft {
            showDialogError(it.message)
            Timber.e("cant fetch authorized user")
        }
    }

    private fun onLoginClicked() {
        val validationResult = validateDomainUseCase(domain = currentState.domainInputState.value)

        validationResult.onRight {
            getApplicationCredentials()
        }.onLeft { error ->
            setState {
                copy(
                    domainInputState = domainInputState.update(error)
                )
            }
        }
    }

    private fun onDomainChanged(domain: String) {
        setState {
            copy(
                domainInputState = domainInputState.update(value = domain)
            )
        }
    }

    private fun getApplicationCredentials() = viewModelScope.launch {
        val domain = currentState.domainInputState.value
        val appCredentials = authRepository.registerApp(domain = domain)
        appCredentials
            .onRight { credentials ->
                setState {
                    copy(
                        applicationCredentials = credentials
                    )
                }
                sendEvent(LoginEvent.LaunchAuthorizationActivity(credentials))
            }
            .onLeft {
                Timber.e(it.message)
                showDialogError(it.message)
            }
    }

    private fun dialogDismiss() {
        setState { copy(dialogState = null) }
    }

    private fun showDialogError(message: String) {
        setState { copy(dialogState = LoginState.DialogState.Error(message)) }
    }
}

data class LoginState(
    val domainInputState: StringInputState = StringInputState(value = "mastodon.social"),
    val applicationCredentials: ApplicationCredentials? = null,
    val dialogState: DialogState? = null,
) {
    sealed interface DialogState {
        data class Error(val message: String) : DialogState
    }
}

sealed interface LoginEvent {
    data class LaunchAuthorizationActivity(val applicationCredentials: ApplicationCredentials) : LoginEvent
    data object NavigateToHome : LoginEvent
}

sealed class LoginAction {
    data class OnDomainChanged(val domain: String) : LoginAction()
    data object OnLoginClicked : LoginAction()
    data object DialogDismiss : LoginAction()
    data class HandleLoginResult(val loginResult: Either<AuthorizationException, AuthorizationResponse>) : LoginAction()
}
