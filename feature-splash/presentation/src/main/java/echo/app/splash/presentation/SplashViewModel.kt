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
package echo.app.splash.presentation

import androidx.lifecycle.viewModelScope
import echo.app.core.presentation.BaseViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor() : BaseViewModel<Unit, SplashAction, Unit>(
    initialState = Unit
) {
    override fun handleAction(action: Unit) = Unit

    init {
        checkAuthentication()
    }

    private fun checkAuthentication() = viewModelScope.launch {
        // todo check auth
        delay(1000L)
        sendEvent(SplashAction.NavigateToLogin)
    }
}

sealed interface SplashAction {
    data object NavigateToHome : SplashAction
    data object NavigateToLogin : SplashAction
}
