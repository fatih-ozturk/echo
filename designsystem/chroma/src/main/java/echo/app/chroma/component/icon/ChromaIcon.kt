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
package echo.app.chroma.component.icon

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import echo.app.chroma.tokens.LocalChromaContentColor

@Composable
fun ChromaIcon(
    painter: Painter,
    contentDescription: String?,
    modifier: Modifier = Modifier,
    tint: Color = LocalChromaContentColor.current
) {
    val colorFilter = remember(tint) {
        if (tint == Color.Unspecified) null else ColorFilter.tint(tint)
    }
    Image(
        painter = painter,
        contentDescription = contentDescription,
        modifier = modifier.defaultSizeFor(painter),
        colorFilter = colorFilter
    )
}

private fun Modifier.defaultSizeFor(painter: Painter) = this.then(
    if (painter.intrinsicSize == Size.Unspecified || painter.intrinsicSize.isInfinite()) {
        Modifier.size(ChromaIconDefaults.IconSize)
    } else {
        Modifier
    }
)

private fun Size.isInfinite() = width.isInfinite() && height.isInfinite()
