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

val ChromaIcons.Search: ImageVector
    get() {
        if (_search != null) {
            return _search!!
        }
        _search = Builder(
            name = "Search",
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
                moveTo(382.0f, 600.0f)
                quadToRelative(-92.0f, 0.0f, -156.0f, -64.0f)
                reflectiveQuadToRelative(-64.0f, -156.0f)
                quadToRelative(0.0f, -92.0f, 64.0f, -156.0f)
                reflectiveQuadToRelative(156.0f, -64.0f)
                quadToRelative(92.0f, 0.0f, 156.0f, 64.0f)
                reflectiveQuadToRelative(64.0f, 156.0f)
                quadToRelative(0.0f, 41.0f, -15.0f, 80.0f)
                reflectiveQuadToRelative(-39.0f, 66.0f)
                lineToRelative(240.0f, 240.0f)
                quadToRelative(4.0f, 4.0f, 4.5f, 9.5f)
                reflectiveQuadTo(788.0f, 786.0f)
                quadToRelative(-5.0f, 5.0f, -10.0f, 5.0f)
                reflectiveQuadToRelative(-10.0f, -5.0f)
                lineTo(528.0f, 546.0f)
                quadToRelative(-30.0f, 26.0f, -69.0f, 40.0f)
                reflectiveQuadToRelative(-77.0f, 14.0f)
                close()
                moveTo(382.0f, 572.0f)
                quadToRelative(81.0f, 0.0f, 136.5f, -55.5f)
                reflectiveQuadTo(574.0f, 380.0f)
                quadToRelative(0.0f, -81.0f, -55.5f, -136.5f)
                reflectiveQuadTo(382.0f, 188.0f)
                quadToRelative(-81.0f, 0.0f, -136.5f, 55.5f)
                reflectiveQuadTo(190.0f, 380.0f)
                quadToRelative(0.0f, 81.0f, 55.5f, 136.5f)
                reflectiveQuadTo(382.0f, 572.0f)
                close()
            }
        }
            .build()
        return _search!!
    }

private var _search: ImageVector? = null
