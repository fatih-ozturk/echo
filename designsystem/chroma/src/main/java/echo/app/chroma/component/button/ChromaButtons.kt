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
package echo.app.chroma.component.button

import android.content.res.Configuration
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.BasicText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import echo.app.chroma.tokens.ChromaTheme

object ChromaButtons {
    @Composable
    fun Primary(
        text: String,
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        leftIcon: Painter? = null,
        rightIcon: Painter? = null,
        colors: ButtonColors = ChromaButtonColors.primary(),
        sizes: ButtonSizes = ChromaButtonSizes.medium(),
        borders: ButtonBorders = ChromaButtonBorders.none(),
    ) = ChromaButtonImpl(
        text = text,
        enabled = enabled,
        colors = colors,
        sizes = sizes,
        onClick = onClick,
        modifier = modifier,
        leftIcon = leftIcon,
        rightIcon = rightIcon,
        borders = borders,
    )

    @Composable
    fun SecondaryGray(
        text: String,
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        leftIcon: Painter? = null,
        rightIcon: Painter? = null,
        colors: ButtonColors = ChromaButtonColors.secondaryGray(),
        sizes: ButtonSizes = ChromaButtonSizes.medium(),
        borders: ButtonBorders = ChromaButtonBorders.secondaryGray(),
    ) = ChromaButtonImpl(
        text = text,
        enabled = enabled,
        colors = colors,
        sizes = sizes,
        onClick = onClick,
        modifier = modifier,
        leftIcon = leftIcon,
        rightIcon = rightIcon,
        borders = borders,
    )

    @Composable
    fun SecondaryColor(
        text: String,
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        leftIcon: Painter? = null,
        rightIcon: Painter? = null,
        colors: ButtonColors = ChromaButtonColors.secondaryColor(),
        sizes: ButtonSizes = ChromaButtonSizes.medium(),
        borders: ButtonBorders = ChromaButtonBorders.secondaryColor(),
    ) = ChromaButtonImpl(
        text = text,
        enabled = enabled,
        colors = colors,
        sizes = sizes,
        onClick = onClick,
        modifier = modifier,
        leftIcon = leftIcon,
        rightIcon = rightIcon,
        borders = borders,
    )

    @Composable
    fun TertiaryGray(
        text: String,
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        leftIcon: Painter? = null,
        rightIcon: Painter? = null,
        colors: ButtonColors = ChromaButtonColors.tertiaryGray(),
        sizes: ButtonSizes = ChromaButtonSizes.medium(),
        borders: ButtonBorders = ChromaButtonBorders.none(),
    ) = ChromaButtonImpl(
        text = text,
        enabled = enabled,
        colors = colors,
        sizes = sizes,
        onClick = onClick,
        modifier = modifier,
        leftIcon = leftIcon,
        rightIcon = rightIcon,
        borders = borders,
    )

    @Composable
    fun TertiaryColor(
        text: String,
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        leftIcon: Painter? = null,
        rightIcon: Painter? = null,
        colors: ButtonColors = ChromaButtonColors.tertiaryColor(),
        sizes: ButtonSizes = ChromaButtonSizes.medium(),
        borders: ButtonBorders = ChromaButtonBorders.none(),
    ) = ChromaButtonImpl(
        text = text,
        enabled = enabled,
        colors = colors,
        sizes = sizes,
        onClick = onClick,
        modifier = modifier,
        leftIcon = leftIcon,
        rightIcon = rightIcon,
        borders = borders,
    )

    @Composable
    fun PrimaryDestructive(
        text: String,
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        leftIcon: Painter? = null,
        rightIcon: Painter? = null,
        colors: ButtonColors = ChromaButtonColors.primaryDestructive(),
        sizes: ButtonSizes = ChromaButtonSizes.medium(),
        borders: ButtonBorders = ChromaButtonBorders.none(),
    ) = ChromaButtonImpl(
        text = text,
        enabled = enabled,
        colors = colors,
        sizes = sizes,
        onClick = onClick,
        modifier = modifier,
        leftIcon = leftIcon,
        rightIcon = rightIcon,
        borders = borders,
    )

    @Composable
    fun SecondaryDestructive(
        text: String,
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        leftIcon: Painter? = null,
        rightIcon: Painter? = null,
        colors: ButtonColors = ChromaButtonColors.secondaryDestructive(),
        sizes: ButtonSizes = ChromaButtonSizes.medium(),
        borders: ButtonBorders = ChromaButtonBorders.secondaryDestructive(),
    ) = ChromaButtonImpl(
        text = text,
        enabled = enabled,
        colors = colors,
        sizes = sizes,
        onClick = onClick,
        modifier = modifier,
        leftIcon = leftIcon,
        rightIcon = rightIcon,
        borders = borders,
    )

    @Composable
    fun TertiaryDestructive(
        text: String,
        onClick: () -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        leftIcon: Painter? = null,
        rightIcon: Painter? = null,
        colors: ButtonColors = ChromaButtonColors.tertiaryDestructive(),
        sizes: ButtonSizes = ChromaButtonSizes.medium(),
        borders: ButtonBorders = ChromaButtonBorders.none(),
    ) = ChromaButtonImpl(
        text = text,
        enabled = enabled,
        colors = colors,
        sizes = sizes,
        onClick = onClick,
        modifier = modifier,
        leftIcon = leftIcon,
        rightIcon = rightIcon,
        borders = borders,
    )
}

@Composable
internal fun ChromaButtonImpl(
    text: String,
    enabled: Boolean,
    colors: ButtonColors,
    sizes: ButtonSizes,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    leftIcon: Painter? = null,
    rightIcon: Painter? = null,
    borders: ButtonBorders = ChromaButtonBorders.none(),
) {
    val contentColor = if (enabled) colors.contentColor else colors.disabledContentColor
    val containerColor = if (enabled) colors.containerColor else colors.disabledContainerColor
    val border = if (enabled) borders.stroke else borders.disabled
    val colorFilter = ColorFilter.tint(
        if (enabled) colors.contentColor else colors.disabledContentColor,
    )
    val mergedStyle =
        sizes.textStyle.merge(
            TextStyle(
                color = contentColor,
            ),
        )
    Box(
        modifier = modifier
            .height(sizes.height)
            .graphicsLayer(shape = ChromaTheme.shapes.radiusMd, clip = false)
            .then(
                if (border != null) {
                    Modifier.border(
                        border,
                        shape = ChromaTheme.shapes.radiusMd,
                    )
                } else {
                    Modifier
                },
            )
            .clip(shape = ChromaTheme.shapes.radiusMd)
            .background(color = containerColor)
            .clickable(
                enabled = enabled,
                onClick = onClick,
            ),
    ) {
        Row(
            modifier = Modifier
                .padding(sizes.contentPadding)
                .align(Alignment.Center),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            leftIcon?.let {
                Image(
                    modifier = Modifier.size(sizes.iconSize),
                    painter = it,
                    contentDescription = null,
                    colorFilter = colorFilter,
                )
                Spacer(modifier = Modifier.width(sizes.iconPadding))
            }
            BasicText(
                modifier = Modifier.weight(1f, false),
                text = text,
                style = mergedStyle,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
            )
            rightIcon?.let {
                Spacer(modifier = Modifier.width(sizes.iconPadding))
                Image(
                    modifier = Modifier.size(sizes.iconSize),
                    painter = it,
                    contentDescription = null,
                    colorFilter = colorFilter,
                )
            }
        }
    }
}

@Preview
@Preview(uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
private fun ChromaButtonsPreview() {
    ChromaTheme {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(ChromaTheme.colors.bgPrimary)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            ChromaButtons.Primary(
                text = "Button",
                enabled = true,
                onClick = {},
            )

            ChromaButtons.SecondaryGray(
                text = "Button",
                enabled = true,
                onClick = {},
            )

            ChromaButtons.SecondaryColor(
                text = "Button",
                enabled = true,
                onClick = {},
            )

            ChromaButtons.TertiaryGray(
                text = "Button",
                enabled = true,
                onClick = {},
            )

            ChromaButtons.TertiaryColor(
                text = "Button",
                enabled = true,
                onClick = {},
            )

            ChromaButtons.PrimaryDestructive(
                text = "Button",
                onClick = {},
                enabled = true,
            )

            ChromaButtons.SecondaryDestructive(
                text = "Button",
                onClick = {},
                enabled = true,
            )

            ChromaButtons.TertiaryDestructive(
                text = "Button",
                enabled = true,
                onClick = {},
            )
        }
    }
}
