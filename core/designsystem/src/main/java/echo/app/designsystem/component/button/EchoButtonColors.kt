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
package echo.app.designsystem.component.button

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color
import echo.app.designsystem.theme.EchoTheme

@Immutable
class ButtonColors(
    val containerColor: Color,
    val contentColor: Color,
    val disabledContainerColor: Color,
    val disabledContentColor: Color,
)

object EchoButtonColors {
    @Composable
    fun primary(
        containerColor: Color = EchoTheme.colors.buttonPrimaryBg,
        contentColor: Color = EchoTheme.colors.buttonPrimaryFg,
        disabledContainerColor: Color = EchoTheme.colors.bgDisabled,
        disabledContentColor: Color = EchoTheme.colors.fgDisabled,
    ): ButtonColors =
        ButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor,
        )

    @Composable
    fun secondaryGray(
        containerColor: Color = EchoTheme.colors.buttonSecondaryBg,
        contentColor: Color = EchoTheme.colors.buttonSecondaryFg,
        disabledContainerColor: Color = EchoTheme.colors.bgPrimary,
        disabledContentColor: Color = EchoTheme.colors.fgDisabled,
    ): ButtonColors =
        ButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor,
        )

    @Composable
    fun secondaryColor(
        containerColor: Color = EchoTheme.colors.buttonSecondaryColorBg,
        contentColor: Color = EchoTheme.colors.buttonSecondaryColorFg,
        disabledContainerColor: Color = EchoTheme.colors.bgPrimary,
        disabledContentColor: Color = EchoTheme.colors.fgDisabled,
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
        contentColor: Color = EchoTheme.colors.buttonTertiaryFg,
        disabledContainerColor: Color = EchoTheme.colors.bgPrimary,
        disabledContentColor: Color = EchoTheme.colors.fgDisabled,
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
        contentColor: Color = EchoTheme.colors.buttonTertiaryColorFg,
        disabledContainerColor: Color = EchoTheme.colors.bgPrimary,
        disabledContentColor: Color = EchoTheme.colors.fgDisabled,
    ): ButtonColors =
        ButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor,
        )

    @Composable
    fun primaryDestructive(
        containerColor: Color = EchoTheme.colors.buttonPrimaryErrorBg,
        contentColor: Color = EchoTheme.colors.fgWhite,
        disabledContainerColor: Color = EchoTheme.colors.bgPrimary,
        disabledContentColor: Color = EchoTheme.colors.fgDisabled,
    ): ButtonColors =
        ButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor,
        )

    @Composable
    fun secondaryDestructive(
        containerColor: Color = EchoTheme.colors.buttonSecondaryErrorBg,
        contentColor: Color = EchoTheme.colors.buttonSecondaryErrorFg,
        disabledContainerColor: Color = EchoTheme.colors.bgPrimary,
        disabledContentColor: Color = EchoTheme.colors.fgDisabled,
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
        contentColor: Color = EchoTheme.colors.buttonTertiaryErrorFg,
        disabledContainerColor: Color = EchoTheme.colors.bgPrimary,
        disabledContentColor: Color = EchoTheme.colors.fgDisabled,
    ): ButtonColors =
        ButtonColors(
            containerColor = containerColor,
            contentColor = contentColor,
            disabledContainerColor = disabledContainerColor,
            disabledContentColor = disabledContentColor,
        )
}
