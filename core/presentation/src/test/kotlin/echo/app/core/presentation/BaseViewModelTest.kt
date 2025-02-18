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
package echo.app.core.presentation

import app.cash.turbine.test
import io.kotest.matchers.shouldBe
import io.mockk.clearAllMocks
import io.mockk.mockkObject
import io.mockk.verify
import io.mockk.verifyOrder
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Test

class BaseViewModelTest {

    private val dispatcher = StandardTestDispatcher()
    private lateinit var viewModel: TestViewModel

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = TestViewModel()
        mockkObject(viewModel)
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
        clearAllMocks()
    }

    @Test
    fun `when ViewModel is initialized then initial state is correct`() = runTest {
        viewModel.state.test {
            awaitItem() shouldBe TestState.Initial
            cancel()
        }
    }

    @Test
    fun `when setState is called then state flow is updated`() = runTest {
        viewModel.state.test {
            val newState = TestState.Updated(42)

            viewModel.exposeSetState { newState }

            awaitItem() shouldBe TestState.Initial
            awaitItem() shouldBe newState
            cancel()
        }
    }

    @Test
    fun `when trySendAction is called then handleAction is invoked`() = runTest {
        val action = TestAction.SomeAction(1)
        viewModel.trySendAction(action)

        advanceUntilIdle()

        verify(exactly = 1) { viewModel.handleAction(action) }
    }

    @Test
    fun `when sendAction is called then handleAction is invoked`() = runTest {
        val action = TestAction.SomeAction(1)

        viewModel.exposeSendAction(action)

        advanceUntilIdle()

        verify { viewModel.handleAction(action) }
    }

    @Test
    fun `when sendEvent is called then event is emitted`() = runTest {
        viewModel.event.test {
            val event = TestEvent.SomeEvent("test")

            viewModel.exposeSendEvent(event)

            advanceUntilIdle()

            awaitItem() shouldBe event
            cancel()
        }
    }

    @Test
    fun `given multiple actions when processed then handle actions in order`() = runTest {
        val actions = listOf(
            TestAction.SomeAction(1),
            TestAction.SomeAction(2),
            TestAction.SomeAction(3)
        )

        actions.forEach(viewModel::trySendAction)

        advanceUntilIdle()

        verifyOrder {
            actions.forEach { viewModel.handleAction(it) }
        }
    }

    @Test
    fun `given state updates when setState is called then currentState reflects latest state`() =
        runTest {
            viewModel.exposeCurrentState() shouldBe TestState.Initial

            val firstState = TestState.Updated(10)
            viewModel.exposeSetState { firstState }

            advanceUntilIdle()

            viewModel.exposeCurrentState() shouldBe firstState

            val secondState = TestState.Updated(20)
            viewModel.exposeSetState { secondState }

            advanceUntilIdle()

            viewModel.exposeCurrentState() shouldBe secondState
        }

    sealed interface TestState {
        data object Initial : TestState
        data class Updated(val value: Int) : TestState
    }

    sealed interface TestEvent {
        data class SomeEvent(val data: String) : TestEvent
    }

    sealed interface TestAction {
        data class SomeAction(val param: Int) : TestAction
    }

    class TestViewModel : BaseViewModel<TestState, TestEvent, TestAction>(TestState.Initial) {
        override fun handleAction(action: TestAction) = Unit

        fun exposeSendEvent(event: TestEvent) = sendEvent(event)
        suspend fun exposeSendAction(action: TestAction) = sendAction(action)
        fun exposeSetState(state: TestState.() -> TestState) = setState(state)
        fun exposeCurrentState() = currentState
    }
}
