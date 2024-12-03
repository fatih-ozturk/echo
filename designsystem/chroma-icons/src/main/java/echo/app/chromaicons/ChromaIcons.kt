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
@file:Suppress("UNUSED", "UnusedReceiverParameter")

package echo.app.chromaicons

import echo.app.chromaicons.ChromaIcon.DrawableRes

object ChromaIcons

val ChromaIcons.Home: DrawableRes get() = DrawableRes(R.drawable.ic_home)
val ChromaIcons.Notification: DrawableRes get() = DrawableRes(R.drawable.ic_notification)
val ChromaIcons.Search: DrawableRes get() = DrawableRes(R.drawable.ic_search)
val ChromaIcons.Profile: DrawableRes get() = DrawableRes(R.drawable.ic_profile)
