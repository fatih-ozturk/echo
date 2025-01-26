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
package echo.app.chroma

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import app.cash.paparazzi.DeviceConfig
import app.cash.paparazzi.Paparazzi
import com.android.ide.common.rendering.api.SessionParams.RenderingMode
import echo.app.chroma.tokens.ChromaTheme
import org.junit.Rule

open class PaparazziScreenshotTest {

    @get:Rule
    val paparazzi = Paparazzi(
        deviceConfig = DeviceConfig.PIXEL_6_PRO,
        renderingMode = RenderingMode.SHRINK,
        maxPercentDifference = 1.0,
    )

    protected fun snapshot(
        theme: Theme = Theme.Light,
        content: @Composable () -> Unit
    ) {
        paparazzi.snapshot {
            ChromaTheme(
                darkTheme = theme == Theme.Dark,
            ) {
                Box {
                    content()
                }
            }
        }
    }
}
