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
package echo.app.chroma.internal

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.ui.tooling.preview.Preview

@Preview(
    name = "phone",
    group = "devices",
    locale = "fr-rFR",
    device = "spec:width=411dp,height=891dp",
)
@Preview(
    name = "foldable",
    group = "devices",
    locale = "fr-rFR",
    device = "spec:width=673dp,height=841dp",
)
internal annotation class PreviewScreenSizes

@Preview(
    name = "light",
    group = "themes",
    uiMode = UI_MODE_NIGHT_NO,
)
@Preview(
    name = "dark",
    group = "themes",
    uiMode = UI_MODE_NIGHT_YES,
)
internal annotation class PreviewThemes

@PreviewThemes
@PreviewScreenSizes
internal annotation class PreviewChroma
