/*
 * Copyright 2024 Fatih OZTURK
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
package echo.app.designsystem.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import com.google.testing.junit.testparameterinjector.TestParameter
import com.google.testing.junit.testparameterinjector.TestParameterInjector
import echo.app.designsystem.PaparazziScreenshotTest
import echo.app.designsystem.Theme
import echo.app.designsystem.theme.EchoTheme
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(TestParameterInjector::class)
class EchoButtonsTest(
    @TestParameter val variant: Variant,
) : PaparazziScreenshotTest() {

    @Test
    fun testEchoButton(@TestParameter theme: Theme) {
        snapshot(theme) {
            Box(
                modifier = Modifier
                    .background(EchoTheme.colors.bgPrimary)
                    .padding(EchoTheme.spacing.spacingMd),
            ) {
                EchoButtonsVariantFactory.Button(variant)
            }
        }
    }
}
