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
package echo.app.chromaicons

import androidx.compose.ui.graphics.vector.ImageVector
import echo.app.chromaicons.chromaicons.Home
import echo.app.chromaicons.chromaicons.Notification
import echo.app.chromaicons.chromaicons.Person
import echo.app.chromaicons.chromaicons.Search
import kotlin.collections.List as ____KtList

object ChromaIcons

private var __AllIcons: ____KtList<ImageVector>? = null

val ChromaIcons.AllIcons: ____KtList<ImageVector>
    get() {
        if (__AllIcons != null) {
            return __AllIcons!!
        }
        __AllIcons = listOf(Home, Notification, Person, Search)
        return __AllIcons!!
    }
