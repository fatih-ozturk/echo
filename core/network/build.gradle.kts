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
}

android {
    namespace = "echo.app.network"
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.domain)

    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.serialization.json)

    implementation(libs.timber)

    implementation(libs.arrow.core)
    implementation(libs.ktor.core)
    implementation(libs.ktor.auth)
    implementation(libs.ktor.logging)
    implementation(libs.ktor.serialization.json)
    implementation(libs.ktor.content.negotiation)
    implementation(libs.ktor.engine.android)
    testImplementation(libs.junit4)
    testImplementation(libs.kotest)
    testImplementation(libs.ktor.client.mock)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation("org.slf4j:slf4j-nop:2.0.17")
}
