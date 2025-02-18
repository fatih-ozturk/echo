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
package echo.app.chroma.component.textfield

import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.InteractionSource
import androidx.compose.foundation.interaction.collectIsFocusedAsState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import echo.app.chroma.ext.ifTrue
import echo.app.chroma.tokens.ChromaTheme

@Immutable
data class ChromaTextFieldColors(
    val textColor: Color,
    val labelTextColor: Color,
    val placeholderTextColor: Color,
    val disabledPlaceholderTextColor: Color,
    val containerColor: Color,
    val disabledContainerColor: Color,
    val borderColor: Color,
    val borderOuterColor: Color,
    val borderErrorOuterColor: Color,
    val focusedBorderColor: Color,
    val errorBorderColor: Color,
    val disabledBorderColor: Color,
    val hintColor: Color,
    val errorHintColor: Color,
    val trailingIconColor: Color,
    val leadingIconColor: Color,
    val errorIconColor: Color,
) {
    @Composable
    internal fun borderModifier(
        enabled: Boolean,
        isError: Boolean,
        interactionSource: InteractionSource,
    ): State<Modifier> {
        val focused by interactionSource.collectIsFocusedAsState()
        val targetValue =
            when {
                !enabled -> disabledBorderColor
                isError -> errorBorderColor
                focused -> focusedBorderColor
                else -> borderColor
            }
        val borderWidth =
            when {
                focused -> 3.dp
                else -> 1.dp
            }
        val outerBorderColor =
            when {
                !isError -> borderOuterColor
                else -> borderErrorOuterColor
            }
        val modifier = Modifier
            .ifTrue(focused) {
                border(
                    2.dp,
                    outerBorderColor,
                    ChromaTheme.shapes.radiusMd,
                )
            }
            .border(
                borderWidth,
                targetValue,
                ChromaTheme.shapes.radiusMd,
            )

        return rememberUpdatedState(modifier)
    }

    @Composable
    internal fun backgroundColors(enabled: Boolean): State<Color> {
        val targetValue =
            when {
                !enabled -> disabledContainerColor
                else -> containerColor
            }
        return rememberUpdatedState(targetValue)
    }

    @Composable
    internal fun hintTextColors(isError: Boolean): State<Color> {
        val targetValue =
            when {
                !isError -> hintColor
                else -> errorHintColor
            }
        return rememberUpdatedState(targetValue)
    }

    @Composable
    internal fun trailingIconColors(isError: Boolean): State<Color> {
        val targetValue =
            when {
                !isError -> trailingIconColor
                else -> errorIconColor
            }
        return rememberUpdatedState(targetValue)
    }

    @Composable
    internal fun placeholderTextColors(enabled: Boolean): State<Color> {
        val targetValue =
            when {
                !enabled -> disabledPlaceholderTextColor
                else -> placeholderTextColor
            }
        return rememberUpdatedState(targetValue)
    }
}
