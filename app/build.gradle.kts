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
    id("echo.android.application.compose")
}

android {
    namespace = "echo.app"

    defaultConfig {
        applicationId = "echo.app"
        versionCode = 1
        versionName = "1.0"
    }

    ksp {
        arg("room.schemaLocation", "$projectDir/schemas")
        arg("room.generateKotlin", "true")
    }
}

dependencies {
    runtimeOnly(libs.androidx.compose.runtime.tracing)

    implementation(projects.designsystem.chroma)
    implementation(projects.core.common)
    implementation(projects.core.presentation)
    implementation(projects.core.data)
    implementation(projects.core.network)
    implementation(projects.core.database)
    implementation(projects.core.domain)
    implementation(projects.featureSplash.presentation)
    implementation(projects.featureAuthentication.presentation)
    implementation(projects.featureAuthentication.data)
    implementation(projects.featureAuthentication.domain)
    implementation(projects.featureHome.presentation)
    implementation(projects.featureHome.domain)
    implementation(projects.account.impl)
    implementation(projects.account.api)
    implementation(projects.securityCrypto.api)
    implementation(projects.securityCrypto.impl)
    implementation(projects.appConfig.api)

    implementation(libs.arrow.core)
    implementation(libs.ktor.logging)
    implementation(libs.timber)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.hilt.navigation.compose)
    implementation(libs.androidx.navigation.compose)

    implementation(libs.room.ktx)

    testImplementation(libs.kotest)
    testImplementation(libs.robolectric)
    testImplementation(libs.room.testing)
    testImplementation(libs.androidx.test.core)
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.mockk)
    testImplementation(libs.junit4)
    testImplementation(libs.hilt.android.testing)
    testImplementation(libs.androidx.test.ext)
}
