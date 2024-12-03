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

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember

@Composable
fun ChromaTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkTheme) darkColors else lightColors
    ProvideChromaResources(
        typography = chromaTypography,
        colors = colorScheme,
        shapes = chromaShapes,
        spacing = chromaSpacing,
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
fun ProvideChromaResources(
    typography: ChromaTypography,
    colors: ChromaColors,
    shapes: ChromaShapes,
    spacing: ChromaSpacing,
    content: @Composable () -> Unit,
) {
    val colorPalette = remember { colors }
    colorPalette.update(colors)
    CompositionLocalProvider(
        LocalChromaTypographies provides typography,
        LocalChromaColors provides colorPalette,
        LocalChromaShapes provides shapes,
        LocalChromaSpacing provides spacing,
        LocalChromaContentColor provides colorPalette.fgPrimary,
    ) {
        ProvideTextStyle(value = typography.displayMd, content = content)
    }
}

object ChromaTheme {
    val typography: ChromaTypography
        @Composable
        get() = LocalChromaTypographies.current
    val colors: ChromaColors
        @Composable
        get() = LocalChromaColors.current
    val shapes: ChromaShapes
        @Composable
        get() = LocalChromaShapes.current
    val spacing: ChromaSpacing
        @Composable
        get() = LocalChromaSpacing.current
}
