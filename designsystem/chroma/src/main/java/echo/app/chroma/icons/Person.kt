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

val ChromaIcons.Person: ImageVector
    get() {
        if (_person != null) {
            return _person!!
        }
        _person = Builder(
            name = "Person",
            defaultWidth = 24.0.dp,
            defaultHeight = 24.0.dp,
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
                moveTo(480.0f, 448.0f)
                quadToRelative(-44.55f, 0.0f, -76.27f, -31.72f)
                quadTo(372.0f, 384.55f, 372.0f, 340.0f)
                reflectiveQuadToRelative(31.73f, -76.28f)
                quadTo(435.45f, 232.0f, 480.0f, 232.0f)
                reflectiveQuadToRelative(76.28f, 31.72f)
                quadTo(588.0f, 295.45f, 588.0f, 340.0f)
                reflectiveQuadToRelative(-31.72f, 76.28f)
                quadTo(524.55f, 448.0f, 480.0f, 448.0f)
                close()
                moveTo(212.0f, 698.0f)
                verticalLineToRelative(-22.0f)
                quadToRelative(0.0f, -22.0f, 13.5f, -41.5f)
                reflectiveQuadTo(262.0f, 604.0f)
                quadToRelative(55.0f, -26.0f, 109.5f, -39.0f)
                reflectiveQuadTo(480.0f, 552.0f)
                quadToRelative(54.0f, 0.0f, 108.5f, 13.0f)
                reflectiveQuadTo(698.0f, 604.0f)
                quadToRelative(23.0f, 11.0f, 36.5f, 30.5f)
                reflectiveQuadTo(748.0f, 676.0f)
                verticalLineToRelative(22.0f)
                quadToRelative(0.0f, 13.0f, -8.5f, 21.5f)
                reflectiveQuadTo(718.0f, 728.0f)
                lineTo(242.0f, 728.0f)
                quadToRelative(-13.0f, 0.0f, -21.5f, -8.5f)
                reflectiveQuadTo(212.0f, 698.0f)
                close()
                moveTo(240.0f, 700.0f)
                horizontalLineToRelative(480.0f)
                verticalLineToRelative(-24.0f)
                quadToRelative(0.0f, -14.0f, -9.5f, -26.5f)
                reflectiveQuadTo(684.0f, 628.0f)
                quadToRelative(-48.0f, -23.0f, -99.69f, -35.5f)
                quadTo(532.63f, 580.0f, 480.0f, 580.0f)
                reflectiveQuadToRelative(-104.31f, 12.5f)
                quadTo(324.0f, 605.0f, 276.0f, 628.0f)
                quadToRelative(-17.0f, 9.0f, -26.5f, 21.5f)
                reflectiveQuadTo(240.0f, 676.0f)
                verticalLineToRelative(24.0f)
                close()
                moveTo(480.0f, 420.0f)
                quadToRelative(33.0f, 0.0f, 56.5f, -23.5f)
                reflectiveQuadTo(560.0f, 340.0f)
                quadToRelative(0.0f, -33.0f, -23.5f, -56.5f)
                reflectiveQuadTo(480.0f, 260.0f)
                quadToRelative(-33.0f, 0.0f, -56.5f, 23.5f)
                reflectiveQuadTo(400.0f, 340.0f)
                quadToRelative(0.0f, 33.0f, 23.5f, 56.5f)
                reflectiveQuadTo(480.0f, 420.0f)
                close()
                moveTo(480.0f, 340.0f)
                close()
                moveTo(480.0f, 700.0f)
                close()
            }
        }
            .build()
        return _person!!
    }

private var _person: ImageVector? = null
