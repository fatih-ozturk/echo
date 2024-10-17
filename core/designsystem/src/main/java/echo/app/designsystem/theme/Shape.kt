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
package echo.app.designsystem.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.unit.dp

@Immutable
data class EchoShapes(
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

val echoShapes = EchoShapes(
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

internal val LocalEchoShapes = compositionLocalOf<EchoShapes> { error("No Shapes provided") }

val mdShapes = Shapes(
    extraSmall = echoShapes.radiusXs,
    small = echoShapes.radiusSm,
    medium = echoShapes.radiusMd,
    large = echoShapes.radiusLg,
    extraLarge = echoShapes.radiusXl,
)
