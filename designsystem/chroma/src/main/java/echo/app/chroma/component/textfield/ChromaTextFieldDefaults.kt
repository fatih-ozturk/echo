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
package echo.app.chroma.component.textfield

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import echo.app.chroma.tokens.ChromaTheme

object ChromaTextFieldDefaults {
    @Composable
    fun colors(
        textColor: Color = ChromaTheme.colors.textPrimary,
        labelTextColor: Color = ChromaTheme.colors.textSecondary,
        placeholderTextColor: Color = ChromaTheme.colors.textPlaceholder,
        disabledPlaceholderTextColor: Color = ChromaTheme.colors.textDisabled,
        containerColor: Color = ChromaTheme.colors.bgPrimary,
        disabledContainerColor: Color = ChromaTheme.colors.bgDisabledSubtle,
        borderColor: Color = ChromaTheme.colors.borderPrimary,
        borderOuterColor: Color = ChromaTheme.colors.bgBrandSecondary,
        borderErrorOuterColor: Color = ChromaTheme.colors.bgErrorSecondary,
        focusedBorderColor: Color = ChromaTheme.colors.borderBrand,
        errorBorderColor: Color = ChromaTheme.colors.borderError,
        disabledBorderColor: Color = ChromaTheme.colors.borderDisabled,
        hintColor: Color = ChromaTheme.colors.textTertiary,
        errorHintColor: Color = ChromaTheme.colors.textErrorPrimary,
        trailingIconColor: Color = ChromaTheme.colors.fgQuinary,
        leadingIconColor: Color = ChromaTheme.colors.fgQuarterary,
        errorIconColor: Color = ChromaTheme.colors.fgErrorSecondary,
    ): ChromaTextFieldColors = remember(
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
        ChromaTextFieldColors(
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
