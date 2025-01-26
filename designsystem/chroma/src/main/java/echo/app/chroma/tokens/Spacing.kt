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
package echo.app.chroma.tokens

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class ChromaSpacing(
    val spacingNone: Dp,
    val spacingXxs: Dp,
    val spacingXs: Dp,
    val spacingSm: Dp,
    val spacingMd: Dp,
    val spacingLg: Dp,
    val spacingXl: Dp,
    val spacing2Xl: Dp,
    val spacing3Xl: Dp,
    val spacing4Xl: Dp,
    val spacing5Xl: Dp,
    val spacing6Xl: Dp,
    val spacing7Xl: Dp,
    val spacing8Xl: Dp,
    val spacing9Xl: Dp,
    val spacing10Xl: Dp,
    val spacing11Xl: Dp
)

val chromaSpacing = ChromaSpacing(
    spacingNone = 0.dp,
    spacingXxs = 2.dp,
    spacingXs = 4.dp,
    spacingSm = 6.dp,
    spacingMd = 8.dp,
    spacingLg = 12.dp,
    spacingXl = 16.dp,
    spacing2Xl = 20.dp,
    spacing3Xl = 24.dp,
    spacing4Xl = 32.dp,
    spacing5Xl = 40.dp,
    spacing6Xl = 48.dp,
    spacing7Xl = 64.dp,
    spacing8Xl = 80.dp,
    spacing9Xl = 96.dp,
    spacing10Xl = 128.dp,
    spacing11Xl = 160.dp
)

internal val LocalChromaSpacing =
    staticCompositionLocalOf<ChromaSpacing> { error("No spacing provided") }
