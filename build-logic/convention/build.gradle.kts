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
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
    alias(libs.plugins.spotless)
}

group = "echo.app.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.detekt.gradlePlugin)
    compileOnly(libs.spotless.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin)
    compileOnly(libs.dependencyGuard.gradlePlugin)
    compileOnly(libs.kover.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "echo.android.application.compose"
            implementationClass = "EchoAndroidApplicationComposePlugin"
        }
        register("androidApplication") {
            id = "echo.android.application"
            implementationClass = "EchoAndroidApplicationPlugin"
        }
        register("detekt") {
            id = "echo.detekt"
            implementationClass = "EchoAndroidDetektPlugin"
        }
        register("androidFeature") {
            id = "echo.android.feature"
            implementationClass = "EchoAndroidFeaturePlugin"
        }
        register("androidHilt") {
            id = "echo.hilt"
            implementationClass = "EchoAndroidHiltPlugin"
        }
        register("androidLibraryCompose") {
            id = "echo.android.library.compose"
            implementationClass = "EchoAndroidLibraryComposePlugin"
        }
        register("androidLibrary") {
            id = "echo.android.library"
            implementationClass = "EchoAndroidLibraryPlugin"
        }
        register("androidRoom") {
            id = "echo.android.room"
            implementationClass = "EchoAndroidRoomPlugin"
        }
        register("androidSpotless") {
            id = "echo.spotless"
            implementationClass = "EchoAndroidSpotlessPlugin"
        }
        register("dependenctGuard") {
            id = "echo.dependencyGuard"
            implementationClass = "EchoDependencyGuardPlugin"
        }
        register("hilt") {
            id = "echo.hilt"
            implementationClass = "EchoHiltPlugin"
        }
        register("jvmLibrary") {
            id = "echo.jvm.library"
            implementationClass = "EchoJvmLibraryPlugin"
        }
        register("serialization") {
            id = "echo.serialization"
            implementationClass = "EchoSerializationPlugin"
        }
    }
}

spotless {
    kotlin {
        target("**/*.kt")
        targetExclude("**/build/**/*.kt")
        licenseHeaderFile(
            rootProject.file("./../spotless/copyright.kt"),
            "^(package|object|import|interface|@)",
        )
    }

    kotlinGradle {
        target("**/*.gradle.kts")
        targetExclude("**/build/**/*.kts")
        licenseHeaderFile(
            rootProject.file("./../spotless/copyright.kts"),
            "(^(?![\\/ ]\\*).*\$)",
        )
    }

    format("xml") {
        target("**/*.xml")
        targetExclude("**/build/**/*.xml")
        licenseHeaderFile(
            rootProject.file("./../spotless/copyright.xml"),
            "(<[^!?])",
        )
    }
}

