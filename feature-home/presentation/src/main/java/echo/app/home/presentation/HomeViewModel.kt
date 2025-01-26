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
package echo.app.home.presentation

import echo.app.core.presentation.BaseViewModel
import javax.inject.Inject

class HomeViewModel @Inject constructor() : BaseViewModel<HomeState, HomeAction, HomeEffect>(
    initialState = HomeState()
) {
    override fun handleAction(action: HomeEffect) = Unit
}

data class HomeState(
    val id: Int = 0
)

sealed interface HomeAction

sealed interface HomeEffect
