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
package echo.app.chroma.tokens

import androidx.compose.material3.Typography
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import echo.app.chroma.R

val chromaFonts = FontFamily(
    Font(R.font.inter_regular, FontWeight.Normal),
    Font(R.font.inter_medium, FontWeight.Medium),
    Font(R.font.inter_semibold, FontWeight.SemiBold),
    Font(R.font.inter_bold, FontWeight.Bold),
)

data class ChromaTypography(
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

internal val chromaTypography = ChromaTypography(
    displayXl = TextStyle(
        fontFamily = chromaFonts,
        fontSize = 60.sp,
        lineHeight = 72.sp,
        letterSpacing = (-1.2).sp,
    ),
    displayLg = TextStyle(
        fontFamily = chromaFonts,
        fontSize = 48.sp,
        lineHeight = 60.sp,
        letterSpacing = (-0.96).sp,
    ),
    displayMd = TextStyle(
        fontFamily = chromaFonts,
        fontSize = 36.sp,
        lineHeight = 44.sp,
        letterSpacing = (-0.72).sp,
    ),
    displaySm = TextStyle(
        fontFamily = chromaFonts,
        fontSize = 30.sp,
        lineHeight = 38.sp,
    ),
    displayXs = TextStyle(
        fontFamily = chromaFonts,
        fontSize = 24.sp,
        lineHeight = 32.sp,
        letterSpacing = 0.sp,
    ),
    textXl = TextStyle(
        fontFamily = chromaFonts,
        fontSize = 20.sp,
        lineHeight = 30.sp,
    ),
    textLg = TextStyle(
        fontFamily = chromaFonts,
        fontSize = 18.sp,
        lineHeight = 28.sp,
    ),
    textMd = TextStyle(
        fontFamily = chromaFonts,
        fontSize = 16.sp,
        lineHeight = 24.sp,
        letterSpacing = 0.1.sp,
    ),
    textSm = TextStyle(
        fontFamily = chromaFonts,
        fontSize = 14.sp,
        lineHeight = 20.sp,
    ),
    textXs = TextStyle(
        fontFamily = chromaFonts,
        fontSize = 12.sp,
        lineHeight = 18.sp,
    ),
)

internal val LocalChromaTypographies = compositionLocalOf<ChromaTypography> {
    error("No typography provided!")
}

val mdTypography = Typography(
    displayLarge = chromaTypography.displayXl,
    displayMedium = chromaTypography.displayLg,
    displaySmall = chromaTypography.displayMd,
    headlineLarge = chromaTypography.displayMd,
    headlineMedium = chromaTypography.displaySm,
    headlineSmall = chromaTypography.displayXs,
    titleLarge = chromaTypography.displayXs,
    titleMedium = chromaTypography.textMd,
    titleSmall = chromaTypography.textSm,
    bodyLarge = chromaTypography.textMd,
    bodyMedium = chromaTypography.textSm,
    bodySmall = chromaTypography.textXs,
    labelLarge = chromaTypography.textSm,
    labelMedium = chromaTypography.textXs,
    labelSmall = chromaTypography.textXs,
)
