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

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember

@Composable
fun EchoTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkTheme) darkColors else lightColors
    ProvideEchoResources(
        typography = echoTypography,
        colors = colorScheme,
        shapes = echoShapes,
        spacing = echoSpacing,
    ) {
        MaterialTheme(
            colorScheme = colorScheme.asMaterial3Colors(),
            typography = mdTypography,
            shapes = mdShapes,
            content = content,
        )
    }
}

@Composable
fun ProvideEchoResources(
    typography: EchoTypography,
    colors: EchoColors,
    shapes: EchoShapes,
    spacing: EchoSpacing,
    content: @Composable () -> Unit,
) {
    val colorPalette = remember { colors }
    colorPalette.update(colors)
    CompositionLocalProvider(
        LocalEchoTypographies provides typography,
        LocalEchoColors provides colorPalette,
        LocalEchoShapes provides shapes,
        LocalEchoSpacing provides spacing,
        LocalEchoContentColor provides colorPalette.fgPrimary,
    ) {
        ProvideTextStyle(value = typography.displayMd, content = content)
    }
}

object EchoTheme {
    val typography: EchoTypography
        @Composable
        get() = LocalEchoTypographies.current
    val colors: EchoColors
        @Composable
        get() = LocalEchoColors.current
    val shapes: EchoShapes
        @Composable
        get() = LocalEchoShapes.current
    val spacing: EchoSpacing
        @Composable
        get() = LocalEchoSpacing.current
}
