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
package echo.app.chroma.component.navbar

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout

@Composable
fun ChromaNavigationBarItem(
    onClick: () -> Unit,
    icon: @Composable () -> Unit,
    modifier: Modifier = Modifier,
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .clickable(
                onClick = onClick,
                indication = null,
                interactionSource = remember { MutableInteractionSource() },
            ),
        contentAlignment = Alignment.Center,
    ) {
        Layout(
            content = icon,
            measurePolicy = { measurables, constraints ->
                require(measurables.isNotEmpty()) {
                    "Must have at least one measurable"
                }
                val placeables = measurables.map { measurable ->
                    measurable.measure(constraints)
                }

                layout(
                    width = constraints.maxWidth,
                    height = constraints.maxHeight,
                ) {
                    placeables.forEach { placeable ->
                        placeable.placeRelative(
                            x = (constraints.maxWidth - placeable.width) / 2,
                            y = (constraints.maxHeight - placeable.height) / 2,
                        )
                    }
                }
            },
        )
    }
}
