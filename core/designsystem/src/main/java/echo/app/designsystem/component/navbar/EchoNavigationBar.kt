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
package echo.app.designsystem.component.navbar

import androidx.compose.animation.core.animateOffsetAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.isSpecified
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import echo.app.designsystem.theme.EchoTheme

@Composable
fun EchoAnimatedNavBar(
    selectedIndex: Int,
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit = {},
) {
    var itemOffsetList by remember { mutableStateOf(listOf<Offset>()) }

    val selectedItemOffset by remember(selectedIndex, itemOffsetList) {
        mutableStateOf(
            if (itemOffsetList.isEmpty()) {
                Offset.Infinite
            } else {
                itemOffsetList.getOrElse(selectedIndex) { Offset.Infinite }
            },
        )
    }

    val offsetAnimationState by animateOffsetAsState(
        targetValue = selectedItemOffset,
        animationSpec = spring(dampingRatio = 0.7f, stiffness = 700F),
        label = "",
    )

    Box(
        modifier = modifier
            .height(EchoNavigationBarTokens.NavBarHeight)
            .shadow(EchoNavigationBarTokens.NavBarShadow)
            .background(EchoTheme.colors.bgPrimary),
    ) {
        if (offsetAnimationState.isSpecified) {
            Box(
                modifier = Modifier
                    .height(EchoNavigationBarTokens.IndicatorHeight)
                    .width(EchoNavigationBarTokens.IndicatorWidth)
                    .offset {
                        IntOffset(
                            x = offsetAnimationState.x.toInt(),
                            y = offsetAnimationState.y.toInt(),
                        )
                    }
                    .background(
                        color = EchoTheme.colors.bgTertiary,
                        shape = EchoTheme.shapes.radiusSm,
                    ),
            )
        }

        Layout(
            content = content,
            measurePolicy = { measurables, constraints ->
                require(measurables.isNotEmpty()) {
                    "It has to have at least one measurable"
                }
                val itemWidth = constraints.maxWidth / measurables.size
                val placeables = measurables.map { measurable ->
                    measurable.measure(constraints.copy(maxWidth = itemWidth))
                }

                val height = placeables.maxOf { it.height }

                layout(constraints.maxWidth, height) {
                    var navigationBarItemX = 0

                    val positions = arrayListOf<EchoNavigationBarItemPosition>()

                    placeables.forEach { navigationBarItem ->
                        navigationBarItem.placeRelative(navigationBarItemX, 0)

                        positions.add(
                            EchoNavigationBarItemPosition(
                                x = navigationBarItemX +
                                    (navigationBarItem.width / 2f) -
                                    (EchoNavigationBarTokens.IndicatorWidth / 2).toPx(),
                                y = (height / 2).toFloat() -
                                    (EchoNavigationBarTokens.IndicatorHeight.toPx() / 2),
                            ),
                        )

                        navigationBarItemX += navigationBarItem.width
                    }
                    itemOffsetList = positions.map { xCord ->
                        Offset(xCord.x, xCord.y)
                    }
                }
            },
        )
    }
}

internal object EchoNavigationBarTokens {
    val IndicatorWidth = 62.0.dp
    val IndicatorHeight = 32.0.dp
    val NavBarHeight = 80.0.dp
    val NavBarShadow = 8.0.dp
}
