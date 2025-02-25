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
plugins {
    id("echo.android.library")
    id("echo.android.room")
    id("echo.hilt")
}

android {
    namespace = "echo.app.home.data"
}

dependencies {
    implementation(projects.core.data)
    implementation(projects.core.database)
    implementation(projects.core.domain)
    implementation(projects.account.api)
    implementation(projects.featureHome.domain)
    implementation(projects.core.network)

    implementation(libs.arrow.core)
    implementation(libs.timber)

    testImplementation(libs.kotest)
    testImplementation(libs.mockk)
    testImplementation(libs.junit4)
}
