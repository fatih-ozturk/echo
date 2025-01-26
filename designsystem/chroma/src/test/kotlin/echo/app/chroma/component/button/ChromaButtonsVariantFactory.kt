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
package echo.app.chroma.component.button

import androidx.compose.runtime.Composable

object ChromaButtonsVariantFactory {
    @Composable
    fun Button(
        variant: Variant,
    ) {
        when (variant) {
            Variant.PRIMARY -> ChromaButtons.Primary(
                text = "Button",
                onClick = {},
            )

            Variant.SECONDARY_GRAY -> ChromaButtons.SecondaryGray(
                text = "Button",
                onClick = {},
            )

            Variant.SECONDARY_COLOR -> ChromaButtons.SecondaryColor(
                text = "Button",
                onClick = {},
            )

            Variant.TERTIARY_GRAY -> ChromaButtons.TertiaryGray(
                text = "Button",
                onClick = {},
            )

            Variant.TERTIARY_COLOR -> ChromaButtons.TertiaryColor(
                text = "Button",
                onClick = {},
            )

            Variant.PRIMARY_DESTRUCTIVE -> ChromaButtons.PrimaryDestructive(
                text = "Button",
                onClick = {},
            )

            Variant.SECONDARY_DESTRUCTIVE -> ChromaButtons.SecondaryDestructive(
                text = "Button",
                onClick = {},
            )

            Variant.TERTIARY_DESTRUCTIVE -> ChromaButtons.TertiaryDestructive(
                text = "Button",
                onClick = {},
            )
        }
    }
}
