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
package echo.app.chroma.component.button

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import echo.app.chroma.tokens.ChromaTheme

@Immutable
data class ButtonSizes(
    val textStyle: TextStyle,
    val height: Dp,
    val iconSize: Dp,
    val iconPadding: Dp,
    val contentPadding: PaddingValues,
)

object ChromaButtonSizes {
    @Composable
    fun small(
        textStyle: TextStyle =
            ChromaTheme.typography.textSm.copy(
                fontWeight = FontWeight.SemiBold,
            ),
        height: Dp = 36.dp,
        iconSize: Dp = 20.dp,
        iconPadding: Dp = 6.dp,
        contentPadding: PaddingValues =
            PaddingValues(
                vertical = 8.dp,
                horizontal = 12.dp,
            ),
    ) = remember(
        textStyle,
        height,
        iconSize,
        iconPadding,
        contentPadding,
    ) {
        ButtonSizes(
            textStyle = textStyle,
            height = height,
            iconSize = iconSize,
            iconPadding = iconPadding,
            contentPadding = contentPadding,
        )
    }

    @Composable
    fun medium(
        textStyle: TextStyle =
            ChromaTheme.typography.textSm.copy(
                fontWeight = FontWeight.SemiBold,
            ),
        height: Dp = 40.dp,
        iconSize: Dp = 20.dp,
        iconPadding: Dp = 6.dp,
        contentPadding: PaddingValues =
            PaddingValues(
                vertical = 10.dp,
                horizontal = 14.dp,
            ),
    ) = remember(
        textStyle,
        height,
        iconSize,
        iconPadding,
        contentPadding,
    ) {
        ButtonSizes(
            textStyle = textStyle,
            height = height,
            iconSize = iconSize,
            iconPadding = iconPadding,
            contentPadding = contentPadding,
        )
    }

    @Composable
    fun large(
        textStyle: TextStyle =
            ChromaTheme.typography.textMd.copy(
                fontWeight = FontWeight.SemiBold,
            ),
        height: Dp = 44.dp,
        iconSize: Dp = 20.dp,
        iconPadding: Dp = 8.dp,
        contentPadding: PaddingValues =
            PaddingValues(
                vertical = 12.dp,
                horizontal = 16.dp,
            ),
    ) = remember(
        textStyle,
        height,
        iconSize,
        iconPadding,
        contentPadding,
    ) {
        ButtonSizes(
            textStyle = textStyle,
            height = height,
            iconSize = iconSize,
            iconPadding = iconPadding,
            contentPadding = contentPadding,
        )
    }

    @Composable
    fun xlarge(
        textStyle: TextStyle =
            ChromaTheme.typography.textMd.copy(
                fontWeight = FontWeight.SemiBold,
            ),
        height: Dp = 48.dp,
        iconSize: Dp = 20.dp,
        iconPadding: Dp = 8.dp,
        contentPadding: PaddingValues =
            PaddingValues(
                vertical = 14.dp,
                horizontal = 18.dp,
            ),
    ) = remember(
        textStyle,
        height,
        iconSize,
        iconPadding,
        contentPadding,
    ) {
        ButtonSizes(
            textStyle = textStyle,
            height = height,
            iconSize = iconSize,
            iconPadding = iconPadding,
            contentPadding = contentPadding,
        )
    }

    @Composable
    fun xxlarge(
        textStyle: TextStyle =
            ChromaTheme.typography.textMd.copy(
                fontWeight = FontWeight.SemiBold,
            ),
        height: Dp = 44.dp,
        iconSize: Dp = 20.dp,
        iconPadding: Dp = 12.dp,
        contentPadding: PaddingValues =
            PaddingValues(
                vertical = 18.dp,
                horizontal = 22.dp,
            ),
    ) = remember(
        textStyle,
        height,
        iconSize,
        iconPadding,
        contentPadding,
    ) {
        ButtonSizes(
            textStyle = textStyle,
            height = height,
            iconSize = iconSize,
            iconPadding = iconPadding,
            contentPadding = contentPadding,
        )
    }
}
