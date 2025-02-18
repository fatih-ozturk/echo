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
package echo.app.chroma.tokens

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Stable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

object ChromaPalette {
    val brand50: Color = Color(0xFFF5F4FF)
    val brand100: Color = Color(0xFFE7E6FF)
    val brand200: Color = Color(0xFFD2D1FF)
    val brand300: Color = Color(0xFFB7B6FF)
    val brand400: Color = Color(0xFFA3A1FF)
    val brand500: Color = Color(0xFF8C89FF)
    val brand600: Color = Color(0xFF746FFF)
    val brand700: Color = Color(0xFF5A55FF)
    val brand800: Color = Color(0xFF423CFF)
    val brand900: Color = Color(0xFF302AFF)
    val error50: Color = Color(0xFFFEF3F2)
    val error100: Color = Color(0xFFFEE4E2)
    val error200: Color = Color(0xFFFECDCA)
    val error300: Color = Color(0xFFFDA29B)
    val error400: Color = Color(0xFFF97066)
    val error500: Color = Color(0xFFF04438)
    val error600: Color = Color(0xFFD92D20)
    val error700: Color = Color(0xFFB42318)
    val error800: Color = Color(0xFF912018)
    val error950: Color = Color(0xFF55160C)
    val gray25: Color = Color(0xFFFCFCFD)
    val gray50: Color = Color(0xFFF8FAFC)
    val gray100: Color = Color(0xFFEEF2F6)
    val gray200: Color = Color(0xFFE3E8EF)
    val gray300: Color = Color(0xFFCDD5DF)
    val gray400: Color = Color(0xFF9AA4B2)
    val gray500: Color = Color(0xFF697586)
    val gray600: Color = Color(0xFF4B5565)
    val gray700: Color = Color(0xFF364152)
    val gray800: Color = Color(0xFF202939)
    val gray900: Color = Color(0xFF121926)
    val gray950: Color = Color(0xFF0D121C)
    val success50: Color = Color(0xFFECFDF3)
    val success100: Color = Color(0xFFDCFAE6)
    val success400: Color = Color(0xFF47CD89)
    val success500: Color = Color(0xFF17B26A)
    val success600: Color = Color(0xFF079455)
    val textWhite: Color = Color(0xFFF7F7F7)
    val warning50: Color = Color(0xFFFFFAEB)
    val warning100: Color = Color(0xFFFEF0C7)
    val warning400: Color = Color(0xFFFDB022)
    val warning500: Color = Color(0xFFF79009)
    val warning600: Color = Color(0xFFDC6803)
    val white: Color = Color(0xFFFFFFFF)
    val black: Color = Color(0xFF000000)
}

@Stable
class ChromaColors(
    textPrimary: Color,
    textPrimaryOnBrand: Color,
    textSecondary: Color,
    textSecondaryHover: Color,
    textSecondaryOnBrand: Color,
    textTertiary: Color,
    textTertiaryHover: Color,
    textTertiaryOnBrand: Color,
    textQuarterary: Color,
    textQuarteraryOnBrand: Color,
    textWhite: Color,
    textDisabled: Color,
    textPlaceholder: Color,
    textPlaceholderSubtle: Color,
    textBrandPrimary: Color,
    textBrandSecondary: Color,
    textBrandTertiary: Color,
    textBrandTertiaryAlt: Color,
    textErrorPrimary: Color,
    textWarningPrimary: Color,
    textSuccessPrimary: Color,
    bgPrimary: Color,
    bgPrimaryAlt: Color,
    bgPrimaryHover: Color,
    bgPrimarySolid: Color,
    bgSecondary: Color,
    bgSecondaryAlt: Color,
    bgSecondaryHover: Color,
    bgSecondarySubtle: Color,
    bgSecondarySolid: Color,
    bgTertiary: Color,
    bgQuarterary: Color,
    bgActive: Color,
    bgDisabled: Color,
    bgDisabledSubtle: Color,
    bgOverlay: Color,
    bgBrandPrimary: Color,
    bgBrandPrimaryAlt: Color,
    bgBrandSecondary: Color,
    bgBrandSolid: Color,
    bgBrandSolidHover: Color,
    bgBrandSection: Color,
    bgBrandSectionSubtle: Color,
    bgErrorPrimary: Color,
    bgErrorSecondary: Color,
    bgErrorSolid: Color,
    bgWarningPrimary: Color,
    bgWarningSecondary: Color,
    bgWarningSolid: Color,
    bgSuccessPrimary: Color,
    bgSuccessSecondary: Color,
    bgSuccessSolid: Color,
    fgPrimary: Color,
    fgSecondary: Color,
    fgSecondaryHover: Color,
    fgTertiary: Color,
    fgTertiaryHover: Color,
    fgQuarterary: Color,
    fgQuarteraryHover: Color,
    fgQuinary: Color,
    fgQuinaryHover: Color,
    fgSenary: Color,
    fgWhite: Color,
    fgDisabled: Color,
    fgDisabledSubtle: Color,
    fgBrandPrimary: Color,
    fgBrandPrimaryAlt: Color,
    fgBrandSecondary: Color,
    fgErrorPrimary: Color,
    fgErrorSecondary: Color,
    fgWarningPrimary: Color,
    fgWarningSecondary: Color,
    fgSuccessPrimary: Color,
    fgSuccessSecondary: Color,
    borderPrimary: Color,
    borderSecondary: Color,
    borderTertiary: Color,
    borderDisabled: Color,
    borderDisabledSubtle: Color,
    borderBrand: Color,
    borderBrandSolid: Color,
    borderBrandSolidAlt: Color,
    borderError: Color,
    borderErrorSolid: Color,
    buttonPrimaryBg: Color,
    buttonPrimaryFg: Color,
    buttonSecondaryBg: Color,
    buttonSecondaryFg: Color,
    buttonSecondaryBorder: Color,
    buttonSecondaryColorBg: Color,
    buttonSecondaryColorFg: Color,
    buttonSecondaryColorBorder: Color,
    buttonTertiaryFg: Color,
    buttonTertiaryColorFg: Color,
    buttonPrimaryErrorBg: Color,
    buttonSecondaryErrorBg: Color,
    buttonSecondaryErrorFg: Color,
    buttonSecondaryErrorBorder: Color,
    buttonTertiaryErrorFg: Color,
) {
    var textPrimary by mutableStateOf(textPrimary)
        private set
    var textPrimaryOnBrand by mutableStateOf(textPrimaryOnBrand)
        private set
    var textSecondary by mutableStateOf(textSecondary)
        private set
    var textSecondaryHover by mutableStateOf(textSecondaryHover)
        private set
    var textSecondaryOnBrand by mutableStateOf(textSecondaryOnBrand)
        private set
    var textTertiary by mutableStateOf(textTertiary)
        private set
    var textTertiaryHover by mutableStateOf(textTertiaryHover)
        private set
    var textTertiaryOnBrand by mutableStateOf(textTertiaryOnBrand)
        private set
    var textQuarterary by mutableStateOf(textQuarterary)
        private set
    var textQuarteraryOnBrand by mutableStateOf(textQuarteraryOnBrand)
        private set
    var textWhite by mutableStateOf(textWhite)
        private set
    var textDisabled by mutableStateOf(textDisabled)
        private set
    var textPlaceholder by mutableStateOf(textPlaceholder)
        private set
    var textPlaceholderSubtle by mutableStateOf(textPlaceholderSubtle)
        private set
    var textBrandPrimary by mutableStateOf(textBrandPrimary)
        private set
    var textBrandSecondary by mutableStateOf(textBrandSecondary)
        private set
    var textBrandTertiary by mutableStateOf(textBrandTertiary)
        private set
    var textBrandTertiaryAlt by mutableStateOf(textBrandTertiaryAlt)
        private set
    var textErrorPrimary by mutableStateOf(textErrorPrimary)
        private set
    var textWarningPrimary by mutableStateOf(textWarningPrimary)
        private set
    var textSuccessPrimary by mutableStateOf(textSuccessPrimary)
        private set
    var bgPrimary by mutableStateOf(bgPrimary)
        private set
    var bgPrimaryAlt by mutableStateOf(bgPrimaryAlt)
        private set
    var bgPrimaryHover by mutableStateOf(bgPrimaryHover)
        private set
    var bgPrimarySolid by mutableStateOf(bgPrimarySolid)
        private set
    var bgSecondary by mutableStateOf(bgSecondary)
        private set
    var bgSecondaryAlt by mutableStateOf(bgSecondaryAlt)
        private set
    var bgSecondaryHover by mutableStateOf(bgSecondaryHover)
        private set
    var bgSecondarySubtle by mutableStateOf(bgSecondarySubtle)
        private set
    var bgSecondarySolid by mutableStateOf(bgSecondarySolid)
        private set
    var bgTertiary by mutableStateOf(bgTertiary)
        private set
    var bgQuarterary by mutableStateOf(bgQuarterary)
        private set
    var bgActive by mutableStateOf(bgActive)
        private set
    var bgDisabled by mutableStateOf(bgDisabled)
        private set
    var bgDisabledSubtle by mutableStateOf(bgDisabledSubtle)
        private set
    var bgOverlay by mutableStateOf(bgOverlay)
        private set
    var bgBrandPrimary by mutableStateOf(bgBrandPrimary)
        private set
    var bgBrandPrimaryAlt by mutableStateOf(bgBrandPrimaryAlt)
        private set
    var bgBrandSecondary by mutableStateOf(bgBrandSecondary)
        private set
    var bgBrandSolid by mutableStateOf(bgBrandSolid)
        private set
    var bgBrandSolidHover by mutableStateOf(bgBrandSolidHover)
        private set
    var bgBrandSection by mutableStateOf(bgBrandSection)
        private set
    var bgBrandSectionSubtle by mutableStateOf(bgBrandSectionSubtle)
        private set
    var bgErrorPrimary by mutableStateOf(bgErrorPrimary)
        private set
    var bgErrorSecondary by mutableStateOf(bgErrorSecondary)
        private set
    var bgErrorSolid by mutableStateOf(bgErrorSolid)
        private set
    var bgWarningPrimary by mutableStateOf(bgWarningPrimary)
        private set
    var bgWarningSecondary by mutableStateOf(bgWarningSecondary)
        private set
    var bgWarningSolid by mutableStateOf(bgWarningSolid)
        private set
    var bgSuccessPrimary by mutableStateOf(bgSuccessPrimary)
        private set
    var bgSuccessSecondary by mutableStateOf(bgSuccessSecondary)
        private set
    var bgSuccessSolid by mutableStateOf(bgSuccessSolid)
        private set
    var fgPrimary by mutableStateOf(fgPrimary)
        private set
    var fgSecondary by mutableStateOf(fgSecondary)
        private set
    var fgSecondaryHover by mutableStateOf(fgSecondaryHover)
        private set
    var fgTertiary by mutableStateOf(fgTertiary)
        private set
    var fgTertiaryHover by mutableStateOf(fgTertiaryHover)
        private set
    var fgQuarterary by mutableStateOf(fgQuarterary)
        private set
    var fgQuarteraryHover by mutableStateOf(fgQuarteraryHover)
        private set
    var fgQuinary by mutableStateOf(fgQuinary)
        private set
    var fgQuinaryHover by mutableStateOf(fgQuinaryHover)
        private set
    var fgSenary by mutableStateOf(fgSenary)
        private set
    var fgWhite by mutableStateOf(fgWhite)
        private set
    var fgDisabled by mutableStateOf(fgDisabled)
        private set
    var fgDisabledSubtle by mutableStateOf(fgDisabledSubtle)
        private set
    var fgBrandPrimary by mutableStateOf(fgBrandPrimary)
        private set
    var fgBrandPrimaryAlt by mutableStateOf(fgBrandPrimaryAlt)
        private set
    var fgBrandSecondary by mutableStateOf(fgBrandSecondary)
        private set
    var fgErrorPrimary by mutableStateOf(fgErrorPrimary)
        private set
    var fgErrorSecondary by mutableStateOf(fgErrorSecondary)
        private set
    var fgWarningPrimary by mutableStateOf(fgWarningPrimary)
        private set
    var fgWarningSecondary by mutableStateOf(fgWarningSecondary)
        private set
    var fgSuccessPrimary by mutableStateOf(fgSuccessPrimary)
        private set
    var fgSuccessSecondary by mutableStateOf(fgSuccessSecondary)
        private set
    var borderPrimary by mutableStateOf(borderPrimary)
        private set
    var borderSecondary by mutableStateOf(borderSecondary)
        private set
    var borderTertiary by mutableStateOf(borderTertiary)
        private set
    var borderDisabled by mutableStateOf(borderDisabled)
        private set
    var borderDisabledSubtle by mutableStateOf(borderDisabledSubtle)
        private set
    var borderBrand by mutableStateOf(borderBrand)
        private set
    var borderBrandSolid by mutableStateOf(borderBrandSolid)
        private set
    var borderBrandSolidAlt by mutableStateOf(borderBrandSolidAlt)
        private set
    var borderError by mutableStateOf(borderError)
        private set
    var borderErrorSolid by mutableStateOf(borderErrorSolid)
        private set
    var buttonPrimaryBg by mutableStateOf(buttonPrimaryBg)
        private set
    var buttonPrimaryFg by mutableStateOf(buttonPrimaryFg)
        private set
    var buttonSecondaryBg by mutableStateOf(buttonSecondaryBg)
        private set
    var buttonSecondaryFg by mutableStateOf(buttonSecondaryFg)
        private set
    var buttonSecondaryBorder by mutableStateOf(buttonSecondaryBorder)
        private set
    var buttonSecondaryColorBg by mutableStateOf(buttonSecondaryColorBg)
        private set
    var buttonSecondaryColorFg by mutableStateOf(buttonSecondaryColorFg)
        private set
    var buttonSecondaryColorBorder by mutableStateOf(buttonSecondaryColorBorder)
        private set
    var buttonTertiaryFg by mutableStateOf(buttonTertiaryFg)
        private set
    var buttonTertiaryColorFg by mutableStateOf(buttonTertiaryColorFg)
        private set
    var buttonPrimaryErrorBg by mutableStateOf(buttonPrimaryErrorBg)
        private set
    var buttonSecondaryErrorBg by mutableStateOf(buttonSecondaryErrorBg)
        private set
    var buttonSecondaryErrorFg by mutableStateOf(buttonSecondaryErrorFg)
        private set
    var buttonSecondaryErrorBorder by mutableStateOf(buttonSecondaryErrorBorder)
        private set
    var buttonTertiaryErrorFg by mutableStateOf(buttonTertiaryErrorFg)
        private set

    fun update(other: ChromaColors) {
        textPrimary = other.textPrimary
        textPrimaryOnBrand = other.textPrimaryOnBrand
        textSecondary = other.textSecondary
        textSecondaryHover = other.textSecondaryHover
        textSecondaryOnBrand = other.textSecondaryOnBrand
        textTertiary = other.textTertiary
        textTertiaryHover = other.textTertiaryHover
        textTertiaryOnBrand = other.textTertiaryOnBrand
        textQuarterary = other.textQuarterary
        textQuarteraryOnBrand = other.textQuarteraryOnBrand
        textWhite = other.textWhite
        textDisabled = other.textDisabled
        textPlaceholder = other.textPlaceholder
        textPlaceholderSubtle = other.textPlaceholderSubtle
        textBrandPrimary = other.textBrandPrimary
        textBrandSecondary = other.textBrandSecondary
        textBrandTertiary = other.textBrandTertiary
        textBrandTertiaryAlt = other.textBrandTertiaryAlt
        textErrorPrimary = other.textErrorPrimary
        textWarningPrimary = other.textWarningPrimary
        textSuccessPrimary = other.textSuccessPrimary
        bgPrimary = other.bgPrimary
        bgPrimaryAlt = other.bgPrimaryAlt
        bgPrimaryHover = other.bgPrimaryHover
        bgPrimarySolid = other.bgPrimarySolid
        bgSecondary = other.bgSecondary
        bgSecondaryAlt = other.bgSecondaryAlt
        bgSecondaryHover = other.bgSecondaryHover
        bgSecondarySubtle = other.bgSecondarySubtle
        bgSecondarySolid = other.bgSecondarySolid
        bgTertiary = other.bgTertiary
        bgQuarterary = other.bgQuarterary
        bgActive = other.bgActive
        bgErrorPrimary = other.bgErrorPrimary
        bgErrorSecondary = other.bgErrorSecondary
        bgErrorSolid = other.bgErrorSolid
        bgWarningPrimary = other.bgWarningPrimary
        bgWarningSecondary = other.bgWarningSecondary
        bgWarningSolid = other.bgWarningSolid
        bgSuccessPrimary = other.bgSuccessPrimary
        bgSuccessSecondary = other.bgSuccessSecondary
        bgSuccessSolid = other.bgSuccessSolid
        fgPrimary = other.fgPrimary
        fgSecondary = other.fgSecondary
        fgSecondaryHover = other.fgSecondaryHover
        fgTertiary = other.fgTertiary
        fgTertiaryHover = other.fgTertiaryHover
        fgQuarterary = other.fgQuarterary
        fgQuarteraryHover = other.fgQuarteraryHover
        fgQuinary = other.fgQuinary
        fgQuinaryHover = other.fgQuinaryHover
        fgSenary = other.fgSenary
        fgWhite = other.fgWhite
        fgDisabled = other.fgDisabled
        fgDisabledSubtle = other.fgDisabledSubtle
        fgBrandPrimary = other.fgBrandPrimary
        fgBrandPrimaryAlt = other.fgBrandPrimaryAlt
        fgBrandSecondary = other.fgBrandSecondary
        fgErrorPrimary = other.fgErrorPrimary
        fgErrorSecondary = other.fgErrorSecondary
        fgWarningPrimary = other.fgWarningPrimary
        fgWarningSecondary = other.fgWarningSecondary
        fgSuccessPrimary = other.fgSuccessPrimary
        fgSuccessSecondary = other.fgSuccessSecondary
        borderPrimary = other.borderPrimary
        borderSecondary = other.borderSecondary
        borderTertiary = other.borderTertiary
        borderDisabled = other.borderDisabled
        borderDisabledSubtle = other.borderDisabledSubtle
        borderBrand = other.borderBrand
        borderBrandSolid = other.borderBrandSolid
        borderBrandSolidAlt = other.borderBrandSolidAlt
        borderError = other.borderError
        borderErrorSolid = other.borderErrorSolid
        buttonPrimaryBg = other.buttonPrimaryBg
        buttonPrimaryFg = other.buttonPrimaryFg
        buttonSecondaryBg = other.buttonSecondaryBg
        buttonSecondaryFg = other.buttonSecondaryFg
        buttonSecondaryBorder = other.buttonSecondaryBorder
        buttonSecondaryColorBg = other.buttonSecondaryColorBg
        buttonSecondaryColorFg = other.buttonSecondaryColorFg
        buttonSecondaryColorBorder = other.buttonSecondaryColorBorder
        buttonTertiaryFg = other.buttonTertiaryFg
        buttonTertiaryColorFg = other.buttonTertiaryColorFg
        buttonPrimaryErrorBg = other.buttonPrimaryErrorBg
        buttonSecondaryErrorBg = other.buttonSecondaryErrorBg
        buttonSecondaryErrorFg = other.buttonSecondaryErrorFg
        buttonSecondaryErrorBorder = other.buttonSecondaryErrorBorder
        buttonTertiaryErrorFg = other.buttonTertiaryErrorFg
    }
}

val lightColors = ChromaColors(
    textPrimary = ChromaPalette.gray900,
    textPrimaryOnBrand = ChromaPalette.white,
    textSecondary = ChromaPalette.gray700,
    textSecondaryHover = ChromaPalette.gray800,
    textSecondaryOnBrand = ChromaPalette.brand200,
    textTertiary = ChromaPalette.gray600,
    textTertiaryHover = ChromaPalette.gray700,
    textTertiaryOnBrand = ChromaPalette.brand200,
    textQuarterary = ChromaPalette.gray500,
    textQuarteraryOnBrand = ChromaPalette.brand300,
    textWhite = ChromaPalette.textWhite,
    textDisabled = ChromaPalette.gray500,
    textPlaceholder = ChromaPalette.gray500,
    textPlaceholderSubtle = ChromaPalette.gray300,
    textBrandPrimary = ChromaPalette.brand900,
    textBrandSecondary = ChromaPalette.brand700,
    textBrandTertiary = ChromaPalette.brand600,
    textBrandTertiaryAlt = ChromaPalette.brand600,
    textErrorPrimary = ChromaPalette.error600,
    textWarningPrimary = ChromaPalette.warning600,
    textSuccessPrimary = ChromaPalette.success600,
    bgPrimary = ChromaPalette.white,
    bgPrimaryAlt = ChromaPalette.white,
    bgPrimaryHover = ChromaPalette.gray50,
    bgPrimarySolid = ChromaPalette.gray950,
    bgSecondary = ChromaPalette.gray50,
    bgSecondaryAlt = ChromaPalette.gray50,
    bgSecondaryHover = ChromaPalette.gray100,
    bgSecondarySubtle = ChromaPalette.gray25,
    bgSecondarySolid = ChromaPalette.gray600,
    bgTertiary = ChromaPalette.gray100,
    bgQuarterary = ChromaPalette.gray200,
    bgActive = ChromaPalette.gray50,
    bgDisabled = ChromaPalette.gray100,
    bgDisabledSubtle = ChromaPalette.gray50,
    bgOverlay = ChromaPalette.gray950,
    bgBrandPrimary = ChromaPalette.brand50,
    bgBrandPrimaryAlt = ChromaPalette.brand50,
    bgBrandSecondary = ChromaPalette.brand100,
    bgBrandSolid = ChromaPalette.brand600,
    bgBrandSolidHover = ChromaPalette.brand700,
    bgBrandSection = ChromaPalette.brand800,
    bgBrandSectionSubtle = ChromaPalette.brand700,
    bgErrorPrimary = ChromaPalette.error50,
    bgErrorSecondary = ChromaPalette.error100,
    bgErrorSolid = ChromaPalette.error600,
    bgWarningPrimary = ChromaPalette.warning50,
    bgWarningSecondary = ChromaPalette.warning100,
    bgWarningSolid = ChromaPalette.warning600,
    bgSuccessPrimary = ChromaPalette.success50,
    bgSuccessSecondary = ChromaPalette.success100,
    bgSuccessSolid = ChromaPalette.success600,
    fgPrimary = ChromaPalette.gray900,
    fgSecondary = ChromaPalette.gray700,
    fgSecondaryHover = ChromaPalette.gray800,
    fgTertiary = ChromaPalette.gray600,
    fgTertiaryHover = ChromaPalette.gray700,
    fgQuarterary = ChromaPalette.gray500,
    fgQuarteraryHover = ChromaPalette.gray600,
    fgQuinary = ChromaPalette.gray400,
    fgQuinaryHover = ChromaPalette.gray500,
    fgSenary = ChromaPalette.gray300,
    fgWhite = ChromaPalette.textWhite,
    fgDisabled = ChromaPalette.gray400,
    fgDisabledSubtle = ChromaPalette.gray300,
    fgBrandPrimary = ChromaPalette.brand600,
    fgBrandPrimaryAlt = ChromaPalette.brand600,
    fgBrandSecondary = ChromaPalette.brand500,
    fgErrorPrimary = ChromaPalette.error600,
    fgErrorSecondary = ChromaPalette.error500,
    fgWarningPrimary = ChromaPalette.warning600,
    fgWarningSecondary = ChromaPalette.warning500,
    fgSuccessPrimary = ChromaPalette.success600,
    fgSuccessSecondary = ChromaPalette.success500,
    borderPrimary = ChromaPalette.gray300,
    borderSecondary = ChromaPalette.gray200,
    borderTertiary = ChromaPalette.gray100,
    borderDisabled = ChromaPalette.gray300,
    borderDisabledSubtle = ChromaPalette.gray200,
    borderBrand = ChromaPalette.brand300,
    borderBrandSolid = ChromaPalette.brand600,
    borderBrandSolidAlt = ChromaPalette.brand600,
    borderError = ChromaPalette.error300,
    borderErrorSolid = ChromaPalette.error600,
    buttonPrimaryBg = ChromaPalette.brand600,
    buttonPrimaryFg = ChromaPalette.white,
    buttonSecondaryBg = ChromaPalette.white,
    buttonSecondaryFg = ChromaPalette.gray700,
    buttonSecondaryBorder = ChromaPalette.gray300,
    buttonSecondaryColorBg = ChromaPalette.white,
    buttonSecondaryColorFg = ChromaPalette.brand700,
    buttonSecondaryColorBorder = ChromaPalette.brand300,
    buttonTertiaryFg = ChromaPalette.gray600,
    buttonTertiaryColorFg = ChromaPalette.brand700,
    buttonPrimaryErrorBg = ChromaPalette.error600,
    buttonSecondaryErrorBg = ChromaPalette.white,
    buttonSecondaryErrorFg = ChromaPalette.error700,
    buttonSecondaryErrorBorder = ChromaPalette.error300,
    buttonTertiaryErrorFg = ChromaPalette.error700,
)

val darkColors = ChromaColors(
    textPrimary = ChromaPalette.gray50,
    textPrimaryOnBrand = ChromaPalette.gray50,
    textSecondary = ChromaPalette.gray300,
    textSecondaryHover = ChromaPalette.gray200,
    textSecondaryOnBrand = ChromaPalette.gray300,
    textTertiary = ChromaPalette.gray400,
    textTertiaryHover = ChromaPalette.gray300,
    textTertiaryOnBrand = ChromaPalette.gray400,
    textQuarterary = ChromaPalette.gray400,
    textQuarteraryOnBrand = ChromaPalette.gray400,
    textWhite = ChromaPalette.textWhite,
    textDisabled = ChromaPalette.gray500,
    textPlaceholder = ChromaPalette.gray400,
    textPlaceholderSubtle = ChromaPalette.gray700,
    textBrandPrimary = ChromaPalette.gray50,
    textBrandSecondary = ChromaPalette.gray300,
    textBrandTertiary = ChromaPalette.gray400,
    textBrandTertiaryAlt = ChromaPalette.gray50,
    textErrorPrimary = ChromaPalette.error400,
    textWarningPrimary = ChromaPalette.warning400,
    textSuccessPrimary = ChromaPalette.success400,
    bgPrimary = ChromaPalette.gray950,
    bgPrimaryAlt = ChromaPalette.gray900,
    bgPrimaryHover = ChromaPalette.gray800,
    bgPrimarySolid = ChromaPalette.gray900,
    bgSecondary = ChromaPalette.gray900,
    bgSecondaryAlt = ChromaPalette.gray950,
    bgSecondaryHover = ChromaPalette.gray800,
    bgSecondarySubtle = ChromaPalette.gray900,
    bgSecondarySolid = ChromaPalette.gray600,
    bgTertiary = ChromaPalette.gray800,
    bgQuarterary = ChromaPalette.gray700,
    bgActive = ChromaPalette.gray800,
    bgDisabled = ChromaPalette.gray800,
    bgDisabledSubtle = ChromaPalette.gray900,
    bgOverlay = ChromaPalette.gray800,
    bgBrandPrimary = ChromaPalette.brand500,
    bgBrandPrimaryAlt = ChromaPalette.gray800,
    bgBrandSecondary = ChromaPalette.brand600,
    bgBrandSolid = ChromaPalette.brand600,
    bgBrandSolidHover = ChromaPalette.brand500,
    bgBrandSection = ChromaPalette.gray800,
    bgBrandSectionSubtle = ChromaPalette.gray950,
    bgErrorPrimary = ChromaPalette.error500,
    bgErrorSecondary = ChromaPalette.error600,
    bgErrorSolid = ChromaPalette.error600,
    bgWarningPrimary = ChromaPalette.warning500,
    bgWarningSecondary = ChromaPalette.warning600,
    bgWarningSolid = ChromaPalette.warning600,
    bgSuccessPrimary = ChromaPalette.success500,
    bgSuccessSecondary = ChromaPalette.success600,
    bgSuccessSolid = ChromaPalette.success600,
    fgPrimary = ChromaPalette.white,
    fgSecondary = ChromaPalette.gray300,
    fgSecondaryHover = ChromaPalette.gray200,
    fgTertiary = ChromaPalette.gray400,
    fgTertiaryHover = ChromaPalette.gray300,
    fgQuarterary = ChromaPalette.gray400,
    fgQuarteraryHover = ChromaPalette.gray300,
    fgQuinary = ChromaPalette.gray500,
    fgQuinaryHover = ChromaPalette.gray400,
    fgSenary = ChromaPalette.gray600,
    fgWhite = ChromaPalette.textWhite,
    fgDisabled = ChromaPalette.gray500,
    fgDisabledSubtle = ChromaPalette.gray600,
    fgBrandPrimary = ChromaPalette.brand500,
    fgBrandPrimaryAlt = ChromaPalette.gray300,
    fgBrandSecondary = ChromaPalette.brand500,
    fgErrorPrimary = ChromaPalette.error500,
    fgErrorSecondary = ChromaPalette.error400,
    fgWarningPrimary = ChromaPalette.warning500,
    fgWarningSecondary = ChromaPalette.warning400,
    fgSuccessPrimary = ChromaPalette.success500,
    fgSuccessSecondary = ChromaPalette.success400,
    borderPrimary = ChromaPalette.gray700,
    borderSecondary = ChromaPalette.gray800,
    borderTertiary = ChromaPalette.gray800,
    borderDisabled = ChromaPalette.gray700,
    borderDisabledSubtle = ChromaPalette.gray800,
    borderBrand = ChromaPalette.brand400,
    borderBrandSolid = ChromaPalette.brand500,
    borderBrandSolidAlt = ChromaPalette.gray700,
    borderError = ChromaPalette.error400,
    borderErrorSolid = ChromaPalette.error500,
    buttonPrimaryBg = ChromaPalette.brand600,
    buttonPrimaryFg = ChromaPalette.white,
    buttonSecondaryBg = ChromaPalette.gray900,
    buttonSecondaryFg = ChromaPalette.gray300,
    buttonSecondaryBorder = ChromaPalette.gray700,
    buttonSecondaryColorBg = ChromaPalette.gray900,
    buttonSecondaryColorFg = ChromaPalette.gray300,
    buttonSecondaryColorBorder = ChromaPalette.gray700,
    buttonTertiaryFg = ChromaPalette.gray300,
    buttonTertiaryColorFg = ChromaPalette.gray300,
    buttonPrimaryErrorBg = ChromaPalette.error600,
    buttonSecondaryErrorBg = ChromaPalette.error950,
    buttonSecondaryErrorFg = ChromaPalette.error200,
    buttonSecondaryErrorBorder = ChromaPalette.error800,
    buttonTertiaryErrorFg = ChromaPalette.error300,
)

@Suppress("DEPRECATION")
fun ChromaColors.asMaterial3Colors() = ColorScheme(
    primary = this.bgBrandSolid,
    onPrimary = this.fgWhite,
    primaryContainer = this.fgWhite,
    onPrimaryContainer = this.bgBrandSolid,
    inversePrimary = this.bgBrandSolid,
    secondary = this.bgSecondarySolid,
    onSecondary = this.fgWhite,
    secondaryContainer = this.fgWhite,
    onSecondaryContainer = this.bgSecondarySolid,
    tertiary = this.bgTertiary,
    onTertiary = this.fgTertiary,
    tertiaryContainer = this.bgTertiary,
    onTertiaryContainer = this.fgTertiary,
    background = this.bgPrimary,
    onBackground = this.bgPrimarySolid,
    surface = this.bgPrimary,
    onSurface = this.bgPrimarySolid,
    surfaceVariant = this.bgSecondary,
    onSurfaceVariant = this.fgSecondary,
    surfaceTint = this.bgSecondarySubtle,
    inverseSurface = this.fgSecondary,
    inverseOnSurface = this.bgSecondary,
    error = this.bgErrorSolid,
    onError = this.bgErrorPrimary,
    errorContainer = this.bgErrorSolid,
    onErrorContainer = this.bgErrorPrimary,
    outline = this.borderPrimary,
    outlineVariant = this.borderSecondary,
    scrim = this.borderBrand,
)

internal val LocalChromaColors = compositionLocalOf<ChromaColors> { error("No Color provided!") }
