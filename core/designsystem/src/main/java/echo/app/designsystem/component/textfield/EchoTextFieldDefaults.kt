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
package echo.app.designsystem.component.textfield

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import echo.app.designsystem.theme.EchoTheme

object EchoTextFieldDefaults {
    @Composable
    fun colors(
        textColor: Color = EchoTheme.colors.textPrimary,
        labelTextColor: Color = EchoTheme.colors.textSecondary,
        placeholderTextColor: Color = EchoTheme.colors.textPlaceholder,
        disabledPlaceholderTextColor: Color = EchoTheme.colors.textDisabled,
        containerColor: Color = EchoTheme.colors.bgPrimary,
        disabledContainerColor: Color = EchoTheme.colors.bgDisabledSubtle,
        borderColor: Color = EchoTheme.colors.borderPrimary,
        borderOuterColor: Color = EchoTheme.colors.bgBrandSecondary,
        borderErrorOuterColor: Color = EchoTheme.colors.bgErrorSecondary,
        focusedBorderColor: Color = EchoTheme.colors.borderBrand,
        errorBorderColor: Color = EchoTheme.colors.borderError,
        disabledBorderColor: Color = EchoTheme.colors.borderDisabled,
        hintColor: Color = EchoTheme.colors.textTertiary,
        errorHintColor: Color = EchoTheme.colors.textErrorPrimary,
        trailingIconColor: Color = EchoTheme.colors.fgQuinary,
        leadingIconColor: Color = EchoTheme.colors.fgQuarterary,
        errorIconColor: Color = EchoTheme.colors.fgErrorSecondary,
    ): EchoTextFieldColors = remember(
        textColor,
        labelTextColor,
        placeholderTextColor,
        disabledPlaceholderTextColor,
        containerColor,
        disabledContainerColor,
        borderColor,
        borderOuterColor,
        borderErrorOuterColor,
        focusedBorderColor,
        errorBorderColor,
        disabledBorderColor,
        hintColor,
        errorHintColor,
        trailingIconColor,
        leadingIconColor,
        errorIconColor,
    ) {
        EchoTextFieldColors(
            textColor = textColor,
            labelTextColor = labelTextColor,
            placeholderTextColor = placeholderTextColor,
            disabledPlaceholderTextColor = disabledPlaceholderTextColor,
            containerColor = containerColor,
            disabledContainerColor = disabledContainerColor,
            borderColor = borderColor,
            borderOuterColor = borderOuterColor,
            borderErrorOuterColor = borderErrorOuterColor,
            focusedBorderColor = focusedBorderColor,
            errorBorderColor = errorBorderColor,
            disabledBorderColor = disabledBorderColor,
            hintColor = hintColor,
            errorHintColor = errorHintColor,
            trailingIconColor = trailingIconColor,
            leadingIconColor = leadingIconColor,
            errorIconColor = errorIconColor,
        )
    }
}
