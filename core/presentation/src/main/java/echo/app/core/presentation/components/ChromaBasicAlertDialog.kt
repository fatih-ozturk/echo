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
package echo.app.core.presentation.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import echo.app.chroma.component.text.ChromaText
import echo.app.chroma.tokens.ChromaTheme

@Composable
fun ChromaBasicAlertDialog(
    message: String,
    onDismissRequest: () -> Unit,
    modifier: Modifier = Modifier
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(),
    ) {
        Column(
            modifier = modifier
                .fillMaxWidth()
                .background(
                    color = ChromaTheme.colors.bgPrimary,
                    shape = ChromaTheme.shapes.radiusXl,
                )
                .border(
                    width = 1.dp,
                    shape = ChromaTheme.shapes.radiusXl,
                    color = ChromaTheme.colors.borderPrimary
                )
                .padding(ChromaTheme.spacing.spacingXl)
        ) {
            ChromaText(
                text = message,
                style = ChromaTheme.typography.textSm,
                fontWeight = FontWeight.Normal,
                color = ChromaTheme.colors.textTertiary
            )
            ChromaText(
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(top = ChromaTheme.spacing.spacingLg),
                text = "Dismiss",
                style = ChromaTheme.typography.textSm,
                fontWeight = FontWeight.SemiBold,
                color = ChromaTheme.colors.textTertiary,
            )
        }
    }
}

@Preview
@Composable
private fun ChromaBasicAlertDialogPreview() {
    ChromaTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            ChromaBasicAlertDialog(
                message = "Lorem ipsum dolor sit amet consectetur adipisicing elit. Aliquid pariatur, ipsum dolor.",
                onDismissRequest = {}
            )
        }
    }
}
