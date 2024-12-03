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

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import echo.app.chroma.tokens.ChromaTheme

@Immutable
class ButtonColors(
    val containerColor: Color,
    val contentColor: Color,
    val disabledContainerColor: Color,
    val disabledContentColor: Color,
)

object ChromaButtonColors {
    @Composable
    fun primary(
        containerColor: Color = ChromaTheme.colors.buttonPrimaryBg,
        contentColor: Color = ChromaTheme.colors.buttonPrimaryFg,
        disabledContainerColor: Color = ChromaTheme.colors.bgDisabled,
        disabledContentColor: Color = ChromaTheme.colors.fgDisabled,
    ): ButtonColors =
        ButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor,
        )

    @Composable
    fun secondaryGray(
        containerColor: Color = ChromaTheme.colors.buttonSecondaryBg,
        contentColor: Color = ChromaTheme.colors.buttonSecondaryFg,
        disabledContainerColor: Color = ChromaTheme.colors.bgPrimary,
        disabledContentColor: Color = ChromaTheme.colors.fgDisabled,
    ): ButtonColors =
        ButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor,
        )

    @Composable
    fun secondaryColor(
        containerColor: Color = ChromaTheme.colors.buttonSecondaryColorBg,
        contentColor: Color = ChromaTheme.colors.buttonSecondaryColorFg,
        disabledContainerColor: Color = ChromaTheme.colors.bgPrimary,
        disabledContentColor: Color = ChromaTheme.colors.fgDisabled,
    ): ButtonColors =
        ButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor,
        )

    @Composable
    fun tertiaryGray(
        containerColor: Color = Color.Transparent,
        contentColor: Color = ChromaTheme.colors.buttonTertiaryFg,
        disabledContainerColor: Color = ChromaTheme.colors.bgPrimary,
        disabledContentColor: Color = ChromaTheme.colors.fgDisabled,
    ): ButtonColors =
        ButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor,
        )

    @Composable
    fun tertiaryColor(
        containerColor: Color = Color.Transparent,
        contentColor: Color = ChromaTheme.colors.buttonTertiaryColorFg,
        disabledContainerColor: Color = ChromaTheme.colors.bgPrimary,
        disabledContentColor: Color = ChromaTheme.colors.fgDisabled,
    ): ButtonColors =
        ButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor,
        )

    @Composable
    fun primaryDestructive(
        containerColor: Color = ChromaTheme.colors.buttonPrimaryErrorBg,
        contentColor: Color = ChromaTheme.colors.fgWhite,
        disabledContainerColor: Color = ChromaTheme.colors.bgPrimary,
        disabledContentColor: Color = ChromaTheme.colors.fgDisabled,
    ): ButtonColors =
        ButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor,
        )

    @Composable
    fun secondaryDestructive(
        containerColor: Color = ChromaTheme.colors.buttonSecondaryErrorBg,
        contentColor: Color = ChromaTheme.colors.buttonSecondaryErrorFg,
        disabledContainerColor: Color = ChromaTheme.colors.bgPrimary,
        disabledContentColor: Color = ChromaTheme.colors.fgDisabled,
    ): ButtonColors =
        ButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor,
        )

    @Composable
    fun tertiaryDestructive(
        containerColor: Color = Color.Transparent,
        contentColor: Color = ChromaTheme.colors.buttonTertiaryErrorFg,
        disabledContainerColor: Color = ChromaTheme.colors.bgPrimary,
        disabledContentColor: Color = ChromaTheme.colors.fgDisabled,
    ): ButtonColors =
        ButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor,
        )
}
