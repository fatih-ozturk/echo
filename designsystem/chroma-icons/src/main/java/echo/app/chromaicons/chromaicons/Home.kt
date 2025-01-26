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
package echo.app.chromaicons.chromaicons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp
import echo.app.chromaicons.ChromaIcons

val ChromaIcons.Home: ImageVector
    get() {
        if (_home != null) {
            return _home!!
        }
        _home = Builder(
            name = "Home",
            defaultWidth = 24.0.dp,
            defaultHeight = 24.0.dp,
            viewportWidth = 960.0f,
            viewportHeight = 960.0f
        ).apply {
            path(
                fill = SolidColor(Color(0xFFe8eaed)),
                stroke = null,
                strokeLineWidth = 0.0f,
                strokeLineCap = Butt,
                strokeLineJoin = Miter,
                strokeLineMiter = 4.0f,
                pathFillType = NonZero
            ) {
                moveTo(240.0f, 760.0f)
                horizontalLineToRelative(156.0f)
                verticalLineToRelative(-204.0f)
                quadToRelative(0.0f, -12.75f, 8.63f, -21.38f)
                quadTo(413.25f, 526.0f, 426.0f, 526.0f)
                horizontalLineToRelative(108.0f)
                quadToRelative(12.75f, 0.0f, 21.38f, 8.62f)
                quadTo(564.0f, 543.25f, 564.0f, 556.0f)
                verticalLineToRelative(204.0f)
                horizontalLineToRelative(156.0f)
                verticalLineToRelative(-344.0f)
                quadToRelative(0.0f, -8.0f, -3.5f, -14.5f)
                reflectiveQuadTo(707.0f, 390.0f)
                lineTo(499.0f, 233.0f)
                quadToRelative(-8.0f, -7.0f, -19.0f, -7.0f)
                reflectiveQuadToRelative(-19.0f, 7.0f)
                lineTo(253.0f, 390.0f)
                quadToRelative(-6.0f, 5.0f, -9.5f, 11.5f)
                reflectiveQuadTo(240.0f, 416.0f)
                verticalLineToRelative(344.0f)
                close()
                moveTo(212.0f, 760.0f)
                verticalLineToRelative(-344.0f)
                quadToRelative(0.0f, -14.25f, 6.38f, -27.0f)
                quadToRelative(6.37f, -12.75f, 17.62f, -21.0f)
                lineToRelative(208.0f, -158.0f)
                quadToRelative(15.68f, -12.0f, 35.84f, -12.0f)
                quadTo(500.0f, 198.0f, 516.0f, 210.0f)
                lineToRelative(208.0f, 158.0f)
                quadToRelative(11.25f, 8.25f, 17.63f, 21.0f)
                quadToRelative(6.37f, 12.75f, 6.37f, 27.0f)
                verticalLineToRelative(344.0f)
                quadToRelative(0.0f, 11.0f, -8.5f, 19.5f)
                reflectiveQuadTo(720.0f, 788.0f)
                lineTo(566.0f, 788.0f)
                quadToRelative(-12.75f, 0.0f, -21.37f, -8.63f)
                quadTo(536.0f, 770.75f, 536.0f, 758.0f)
                verticalLineToRelative(-204.0f)
                lineTo(424.0f, 554.0f)
                verticalLineToRelative(204.0f)
                quadToRelative(0.0f, 12.75f, -8.62f, 21.37f)
                quadTo(406.75f, 788.0f, 394.0f, 788.0f)
                lineTo(240.0f, 788.0f)
                quadToRelative(-11.0f, 0.0f, -19.5f, -8.5f)
                reflectiveQuadTo(212.0f, 760.0f)
                close()
                moveTo(480.0f, 492.0f)
                close()
            }
        }
            .build()
        return _home!!
    }

private var _home: ImageVector? = null
