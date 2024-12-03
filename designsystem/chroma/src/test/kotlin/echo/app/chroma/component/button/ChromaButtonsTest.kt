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
package echo.app.chroma.component.button

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import com.google.testing.junit.testparameterinjector.TestParameter
import com.google.testing.junit.testparameterinjector.TestParameterInjector
import echo.app.chroma.PaparazziScreenshotTest
import echo.app.chroma.Theme
import echo.app.chroma.tokens.ChromaTheme
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(TestParameterInjector::class)
class ChromaButtonsTest(
    @TestParameter val variant: Variant,
) : PaparazziScreenshotTest() {

    @Test
    fun testChromaButton(@TestParameter theme: Theme) {
        snapshot(theme) {
            Box(
                modifier = Modifier
                    .background(ChromaTheme.colors.bgPrimary)
                    .padding(ChromaTheme.spacing.spacingMd),
            ) {
                ChromaButtonsVariantFactory.Button(variant)
            }
        }
    }
}
