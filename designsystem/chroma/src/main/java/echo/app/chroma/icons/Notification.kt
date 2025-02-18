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
package echo.app.chroma.icons

import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.PathFillType.Companion.NonZero
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.graphics.StrokeJoin.Companion.Miter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.graphics.vector.ImageVector.Builder
import androidx.compose.ui.graphics.vector.path
import androidx.compose.ui.unit.dp

val ChromaIcons.Notification: ImageVector
    get() {
        if (_notification != null) {
            return _notification!!
        }
        _notification = Builder(
            name = "Notification",
            defaultWidth = 24.0.dp,
            defaultHeight =
            24.0.dp,
            viewportWidth = 960.0f,
            viewportHeight = 960.0f,
        ).apply {
            path(
                fill = SolidColor(Color(0xFFe8eaed)),
                stroke = null,
                strokeLineWidth = 0.0f,
                strokeLineCap = Butt,
                strokeLineJoin = Miter,
                strokeLineMiter = 4.0f,
                pathFillType = NonZero,
            ) {
                moveTo(226.0f, 748.0f)
                quadToRelative(-5.95f, 0.0f, -9.98f, -4.04f)
                quadToRelative(-4.02f, -4.03f, -4.02f, -10.0f)
                quadToRelative(0.0f, -5.96f, 4.02f, -9.96f)
                quadToRelative(4.03f, -4.0f, 9.98f, -4.0f)
                horizontalLineToRelative(46.0f)
                verticalLineToRelative(-328.0f)
                quadToRelative(0.0f, -77.0f, 49.5f, -135.0f)
                reflectiveQuadTo(446.0f, 186.0f)
                verticalLineToRelative(-20.0f)
                quadToRelative(0.0f, -14.17f, 9.88f, -24.08f)
                quadToRelative(9.88f, -9.92f, 24.0f, -9.92f)
                reflectiveQuadToRelative(24.12f, 9.92f)
                quadToRelative(10.0f, 9.91f, 10.0f, 24.08f)
                verticalLineToRelative(20.0f)
                quadToRelative(75.0f, 13.0f, 124.5f, 71.0f)
                reflectiveQuadTo(688.0f, 392.0f)
                verticalLineToRelative(328.0f)
                horizontalLineToRelative(46.0f)
                quadToRelative(5.95f, 0.0f, 9.97f, 4.04f)
                quadToRelative(4.03f, 4.03f, 4.03f, 10.0f)
                quadToRelative(0.0f, 5.96f, -4.03f, 9.96f)
                quadToRelative(-4.02f, 4.0f, -9.97f, 4.0f)
                lineTo(226.0f, 748.0f)
                close()
                moveTo(480.0f, 466.0f)
                close()
                moveTo(479.82f, 848.0f)
                quadToRelative(-24.82f, 0.0f, -42.32f, -17.63f)
                quadTo(420.0f, 812.75f, 420.0f, 788.0f)
                horizontalLineToRelative(120.0f)
                quadToRelative(0.0f, 25.0f, -17.68f, 42.5f)
                quadToRelative(-17.67f, 17.5f, -42.5f, 17.5f)
                close()
                moveTo(300.0f, 720.0f)
                horizontalLineToRelative(360.0f)
                verticalLineToRelative(-328.0f)
                quadToRelative(0.0f, -75.0f, -52.5f, -127.5f)
                reflectiveQuadTo(480.0f, 212.0f)
                quadToRelative(-75.0f, 0.0f, -127.5f, 52.5f)
                reflectiveQuadTo(300.0f, 392.0f)
                verticalLineToRelative(328.0f)
                close()
            }
        }
            .build()
        return _notification!!
    }

private var _notification: ImageVector? = null
