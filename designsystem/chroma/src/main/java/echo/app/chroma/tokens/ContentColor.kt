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

import androidx.compose.material3.LocalContentColor
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.ui.graphics.Color

// public fun ChromaColors.contentColorFor(color: Color): Color =
//    when (color) {
//        bgPrimary -> fgPrimary
//        bgSecondary -> fgSecondary
//        bgTertiary -> fgTertiary
//        else -> Color.Unspecified
//    }

val LocalChromaContentColor: ProvidableCompositionLocal<Color> = LocalContentColor
