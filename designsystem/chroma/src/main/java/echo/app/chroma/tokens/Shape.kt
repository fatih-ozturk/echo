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

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.dp

@Immutable
data class ChromaShapes(
    val radiusNone: RoundedCornerShape,
    val radiusXxs: RoundedCornerShape,
    val radiusXs: RoundedCornerShape,
    val radiusSm: RoundedCornerShape,
    val radiusMd: RoundedCornerShape,
    val radiusLg: RoundedCornerShape,
    val radiusXl: RoundedCornerShape,
    val radiusXxl: RoundedCornerShape,
    val radius3xl: RoundedCornerShape,
    val radius4xl: RoundedCornerShape,
    val radiusFull: RoundedCornerShape,
)

val chromaShapes = ChromaShapes(
    radiusNone = RoundedCornerShape(0.dp),
    radiusXxs = RoundedCornerShape(2.dp),
    radiusXs = RoundedCornerShape(4.dp),
    radiusSm = RoundedCornerShape(6.dp),
    radiusMd = RoundedCornerShape(8.dp),
    radiusLg = RoundedCornerShape(10.dp),
    radiusXl = RoundedCornerShape(12.dp),
    radiusXxl = RoundedCornerShape(16.dp),
    radius3xl = RoundedCornerShape(20.dp),
    radius4xl = RoundedCornerShape(24.dp),
    radiusFull = RoundedCornerShape(9999.dp),
)

internal val LocalChromaShapes = compositionLocalOf<ChromaShapes> { error("No Shapes provided") }

val mdShapes = Shapes(
    extraSmall = chromaShapes.radiusXs,
    small = chromaShapes.radiusSm,
    medium = chromaShapes.radiusMd,
    large = chromaShapes.radiusLg,
    extraLarge = chromaShapes.radiusXl,
)
