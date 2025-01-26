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
package echo.app.chroma.component.textfield

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.remember
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

@Immutable
data class ChromaTextFieldSizes(
    val contentPadding: PaddingValues,
    val textFieldHeight: Dp
)

object ChromaTextFieldSizesDefaults {
    @Composable
    fun small(
        contentPadding: PaddingValues =
            PaddingValues(
                vertical = 8.dp,
                horizontal = 12.dp
            ),
        textFieldHeight: Dp = 40.dp
    ) = remember {
        ChromaTextFieldSizes(
            contentPadding = contentPadding,
            textFieldHeight = textFieldHeight
        )
    }

    @Composable
    fun medium(
        contentPadding: PaddingValues =
            PaddingValues(
                vertical = 12.dp,
                horizontal = 14.dp
            ),
        textFieldHeight: Dp = 44.dp
    ) = remember {
        ChromaTextFieldSizes(
            contentPadding = contentPadding,
            textFieldHeight = textFieldHeight
        )
    }
}
