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

import androidx.compose.material3.ColorScheme
import androidx.compose.runtime.Stable
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color

object EchoPalette {
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
class EchoColors(
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

    fun update(other: EchoColors) {
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

val lightColors = EchoColors(
    textPrimary = EchoPalette.gray900,
    textPrimaryOnBrand = EchoPalette.white,
    textSecondary = EchoPalette.gray700,
    textSecondaryHover = EchoPalette.gray800,
    textSecondaryOnBrand = EchoPalette.brand200,
    textTertiary = EchoPalette.gray600,
    textTertiaryHover = EchoPalette.gray700,
    textTertiaryOnBrand = EchoPalette.brand200,
    textQuarterary = EchoPalette.gray500,
    textQuarteraryOnBrand = EchoPalette.brand300,
    textWhite = EchoPalette.textWhite,
    textDisabled = EchoPalette.gray500,
    textPlaceholder = EchoPalette.gray500,
    textPlaceholderSubtle = EchoPalette.gray300,
    textBrandPrimary = EchoPalette.brand900,
    textBrandSecondary = EchoPalette.brand700,
    textBrandTertiary = EchoPalette.brand600,
    textBrandTertiaryAlt = EchoPalette.brand600,
    textErrorPrimary = EchoPalette.error600,
    textWarningPrimary = EchoPalette.warning600,
    textSuccessPrimary = EchoPalette.success600,
    bgPrimary = EchoPalette.white,
    bgPrimaryAlt = EchoPalette.white,
    bgPrimaryHover = EchoPalette.gray50,
    bgPrimarySolid = EchoPalette.gray950,
    bgSecondary = EchoPalette.gray50,
    bgSecondaryAlt = EchoPalette.gray50,
    bgSecondaryHover = EchoPalette.gray100,
    bgSecondarySubtle = EchoPalette.gray25,
    bgSecondarySolid = EchoPalette.gray600,
    bgTertiary = EchoPalette.gray100,
    bgQuarterary = EchoPalette.gray200,
    bgActive = EchoPalette.gray50,
    bgDisabled = EchoPalette.gray100,
    bgDisabledSubtle = EchoPalette.gray50,
    bgOverlay = EchoPalette.gray950,
    bgBrandPrimary = EchoPalette.brand50,
    bgBrandPrimaryAlt = EchoPalette.brand50,
    bgBrandSecondary = EchoPalette.brand100,
    bgBrandSolid = EchoPalette.brand600,
    bgBrandSolidHover = EchoPalette.brand700,
    bgBrandSection = EchoPalette.brand800,
    bgBrandSectionSubtle = EchoPalette.brand700,
    bgErrorPrimary = EchoPalette.error50,
    bgErrorSecondary = EchoPalette.error100,
    bgErrorSolid = EchoPalette.error600,
    bgWarningPrimary = EchoPalette.warning50,
    bgWarningSecondary = EchoPalette.warning100,
    bgWarningSolid = EchoPalette.warning600,
    bgSuccessPrimary = EchoPalette.success50,
    bgSuccessSecondary = EchoPalette.success100,
    bgSuccessSolid = EchoPalette.success600,
    fgPrimary = EchoPalette.gray900,
    fgSecondary = EchoPalette.gray700,
    fgSecondaryHover = EchoPalette.gray800,
    fgTertiary = EchoPalette.gray600,
    fgTertiaryHover = EchoPalette.gray700,
    fgQuarterary = EchoPalette.gray500,
    fgQuarteraryHover = EchoPalette.gray600,
    fgQuinary = EchoPalette.gray400,
    fgQuinaryHover = EchoPalette.gray500,
    fgSenary = EchoPalette.gray300,
    fgWhite = EchoPalette.textWhite,
    fgDisabled = EchoPalette.gray400,
    fgDisabledSubtle = EchoPalette.gray300,
    fgBrandPrimary = EchoPalette.brand600,
    fgBrandPrimaryAlt = EchoPalette.brand600,
    fgBrandSecondary = EchoPalette.brand500,
    fgErrorPrimary = EchoPalette.error600,
    fgErrorSecondary = EchoPalette.error500,
    fgWarningPrimary = EchoPalette.warning600,
    fgWarningSecondary = EchoPalette.warning500,
    fgSuccessPrimary = EchoPalette.success600,
    fgSuccessSecondary = EchoPalette.success500,
    borderPrimary = EchoPalette.gray300,
    borderSecondary = EchoPalette.gray200,
    borderTertiary = EchoPalette.gray100,
    borderDisabled = EchoPalette.gray300,
    borderDisabledSubtle = EchoPalette.gray200,
    borderBrand = EchoPalette.brand300,
    borderBrandSolid = EchoPalette.brand600,
    borderBrandSolidAlt = EchoPalette.brand600,
    borderError = EchoPalette.error300,
    borderErrorSolid = EchoPalette.error600,
    buttonPrimaryBg = EchoPalette.brand600,
    buttonPrimaryFg = EchoPalette.white,
    buttonSecondaryBg = EchoPalette.white,
    buttonSecondaryFg = EchoPalette.gray700,
    buttonSecondaryBorder = EchoPalette.gray300,
    buttonSecondaryColorBg = EchoPalette.white,
    buttonSecondaryColorFg = EchoPalette.brand700,
    buttonSecondaryColorBorder = EchoPalette.brand300,
    buttonTertiaryFg = EchoPalette.gray600,
    buttonTertiaryColorFg = EchoPalette.brand700,
    buttonPrimaryErrorBg = EchoPalette.error600,
    buttonSecondaryErrorBg = EchoPalette.white,
    buttonSecondaryErrorFg = EchoPalette.error700,
    buttonSecondaryErrorBorder = EchoPalette.error300,
    buttonTertiaryErrorFg = EchoPalette.error700,
)

val darkColors = EchoColors(
    textPrimary = EchoPalette.gray50,
    textPrimaryOnBrand = EchoPalette.gray50,
    textSecondary = EchoPalette.gray300,
    textSecondaryHover = EchoPalette.gray200,
    textSecondaryOnBrand = EchoPalette.gray300,
    textTertiary = EchoPalette.gray400,
    textTertiaryHover = EchoPalette.gray300,
    textTertiaryOnBrand = EchoPalette.gray400,
    textQuarterary = EchoPalette.gray400,
    textQuarteraryOnBrand = EchoPalette.gray400,
    textWhite = EchoPalette.textWhite,
    textDisabled = EchoPalette.gray500,
    textPlaceholder = EchoPalette.gray400,
    textPlaceholderSubtle = EchoPalette.gray700,
    textBrandPrimary = EchoPalette.gray50,
    textBrandSecondary = EchoPalette.gray300,
    textBrandTertiary = EchoPalette.gray400,
    textBrandTertiaryAlt = EchoPalette.gray50,
    textErrorPrimary = EchoPalette.error400,
    textWarningPrimary = EchoPalette.warning400,
    textSuccessPrimary = EchoPalette.success400,
    bgPrimary = EchoPalette.gray950,
    bgPrimaryAlt = EchoPalette.gray900,
    bgPrimaryHover = EchoPalette.gray800,
    bgPrimarySolid = EchoPalette.gray900,
    bgSecondary = EchoPalette.gray900,
    bgSecondaryAlt = EchoPalette.gray950,
    bgSecondaryHover = EchoPalette.gray800,
    bgSecondarySubtle = EchoPalette.gray900,
    bgSecondarySolid = EchoPalette.gray600,
    bgTertiary = EchoPalette.gray800,
    bgQuarterary = EchoPalette.gray700,
    bgActive = EchoPalette.gray800,
    bgDisabled = EchoPalette.gray800,
    bgDisabledSubtle = EchoPalette.gray900,
    bgOverlay = EchoPalette.gray800,
    bgBrandPrimary = EchoPalette.brand500,
    bgBrandPrimaryAlt = EchoPalette.gray800,
    bgBrandSecondary = EchoPalette.brand600,
    bgBrandSolid = EchoPalette.brand600,
    bgBrandSolidHover = EchoPalette.brand500,
    bgBrandSection = EchoPalette.gray800,
    bgBrandSectionSubtle = EchoPalette.gray950,
    bgErrorPrimary = EchoPalette.error500,
    bgErrorSecondary = EchoPalette.error600,
    bgErrorSolid = EchoPalette.error600,
    bgWarningPrimary = EchoPalette.warning500,
    bgWarningSecondary = EchoPalette.warning600,
    bgWarningSolid = EchoPalette.warning600,
    bgSuccessPrimary = EchoPalette.success500,
    bgSuccessSecondary = EchoPalette.success600,
    bgSuccessSolid = EchoPalette.success600,
    fgPrimary = EchoPalette.white,
    fgSecondary = EchoPalette.gray300,
    fgSecondaryHover = EchoPalette.gray200,
    fgTertiary = EchoPalette.gray400,
    fgTertiaryHover = EchoPalette.gray300,
    fgQuarterary = EchoPalette.gray400,
    fgQuarteraryHover = EchoPalette.gray300,
    fgQuinary = EchoPalette.gray500,
    fgQuinaryHover = EchoPalette.gray400,
    fgSenary = EchoPalette.gray600,
    fgWhite = EchoPalette.textWhite,
    fgDisabled = EchoPalette.gray500,
    fgDisabledSubtle = EchoPalette.gray600,
    fgBrandPrimary = EchoPalette.brand500,
    fgBrandPrimaryAlt = EchoPalette.gray300,
    fgBrandSecondary = EchoPalette.brand500,
    fgErrorPrimary = EchoPalette.error500,
    fgErrorSecondary = EchoPalette.error400,
    fgWarningPrimary = EchoPalette.warning500,
    fgWarningSecondary = EchoPalette.warning400,
    fgSuccessPrimary = EchoPalette.success500,
    fgSuccessSecondary = EchoPalette.success400,
    borderPrimary = EchoPalette.gray700,
    borderSecondary = EchoPalette.gray800,
    borderTertiary = EchoPalette.gray800,
    borderDisabled = EchoPalette.gray700,
    borderDisabledSubtle = EchoPalette.gray800,
    borderBrand = EchoPalette.brand400,
    borderBrandSolid = EchoPalette.brand500,
    borderBrandSolidAlt = EchoPalette.gray700,
    borderError = EchoPalette.error400,
    borderErrorSolid = EchoPalette.error500,
    buttonPrimaryBg = EchoPalette.brand600,
    buttonPrimaryFg = EchoPalette.white,
    buttonSecondaryBg = EchoPalette.gray900,
    buttonSecondaryFg = EchoPalette.gray300,
    buttonSecondaryBorder = EchoPalette.gray700,
    buttonSecondaryColorBg = EchoPalette.gray900,
    buttonSecondaryColorFg = EchoPalette.gray300,
    buttonSecondaryColorBorder = EchoPalette.gray700,
    buttonTertiaryFg = EchoPalette.gray300,
    buttonTertiaryColorFg = EchoPalette.gray300,
    buttonPrimaryErrorBg = EchoPalette.error600,
    buttonSecondaryErrorBg = EchoPalette.error950,
    buttonSecondaryErrorFg = EchoPalette.error200,
    buttonSecondaryErrorBorder = EchoPalette.error800,
    buttonTertiaryErrorFg = EchoPalette.error300,
)

@Suppress("DEPRECATION") // TODO: Fix
fun EchoColors.asMaterial3Colors() = ColorScheme(
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

internal val LocalEchoColors = compositionLocalOf<EchoColors> { error("No Color provided!") }
