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
package echo.app.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import echo.app.designsystem.R

val echoFonts = FontFamily(
    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_semibold, FontWeight.SemiBold),
    Font(R.font.inter_bold, FontWeight.Bold),
)

data class EchoTypography(
    val displayXl: TextStyle,
    val displayLg: TextStyle,
    val displayMd: TextStyle,
    val displaySm: TextStyle,
    val displayXs: TextStyle,
    val textXl: TextStyle,
    val textLg: TextStyle,
    val textMd: TextStyle,
    val textSm: TextStyle,
    val textXs: TextStyle,
)

internal val echoTypography = EchoTypography(
    displayXl = TextStyle(
        fontFamily = echoFonts,
        fontSize = 60.sp,
        lineHeight = 72.sp,
        letterSpacing = (-1.2).sp,
    ),
    displayLg = TextStyle(
        fontFamily = echoFonts,
        fontSize = 48.sp,
        lineHeight = 60.sp,
        letterSpacing = (-0.96).sp,
    ),
    displayMd = TextStyle(
        fontFamily = echoFonts,
        fontSize = 36.sp,
        lineHeight = 44.sp,
        letterSpacing = (-0.72).sp,
    ),
    displaySm = TextStyle(
        fontFamily = echoFonts,
        fontSize = 30.sp,
        lineHeight = 38.sp,
    ),
    displayXs = TextStyle(
        fontFamily = echoFonts,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp,
    ),
    textXl = TextStyle(
        fontFamily = echoFonts,
        fontSize = 20.sp,
        lineHeight = 30.sp,
    ),
    textLg = TextStyle(
        fontFamily = echoFonts,
        fontSize = 18.sp,
        lineHeight = 28.sp,
    ),
    textMd = TextStyle(
        fontFamily = echoFonts,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.1.sp,
    ),
    textSm = TextStyle(
        fontFamily = echoFonts,
        fontSize = 14.sp,
        lineHeight = 20.sp,
    ),
    textXs = TextStyle(
        fontFamily = echoFonts,
        fontSize = 12.sp,
        lineHeight = 18.sp,
    ),
)

internal val LocalEchoTypographies = compositionLocalOf<EchoTypography> {
    error("No typography provided!")
}

val mdTypography = Typography(
    displayLarge = echoTypography.displayXl,
    displayMedium = echoTypography.displayLg,
    displaySmall = echoTypography.displayMd,
    headlineLarge = echoTypography.displayMd,
    headlineMedium = echoTypography.displaySm,
    headlineSmall = echoTypography.displayXs,
    titleLarge = echoTypography.displayXs,
    titleMedium = echoTypography.textMd,
    titleSmall = echoTypography.textSm,
    bodyLarge = echoTypography.textMd,
    bodyMedium = echoTypography.textSm,
    bodySmall = echoTypography.textXs,
    labelLarge = echoTypography.textSm,
    labelMedium = echoTypography.textXs,
    labelSmall = echoTypography.textXs,
)
