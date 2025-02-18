@file:Suppress("UnstableApiUsage")
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
import echo.app.utils.Versions
import echo.app.utils.configureAndroidLibrary
import echo.app.utils.configureKotlin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

class EchoAndroidLibraryPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.library")
                apply("org.jetbrains.kotlin.android")
                apply("org.jetbrains.kotlinx.kover")
                apply("echo.spotless")
                apply("echo.detekt")
                apply("echo.serialization")
            }

            configureAndroidLibrary {
                compileSdk = Versions.COMPILE_SDK

                defaultConfig {
                    minSdk = Versions.MIN_SDK
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }
                packaging {
                    resources {
                        excludes += setOf(
                            "META-INF/LICENSE.md",
                            "META-INF/LICENSE-notice.md",
                        )
                    }
                }
                testOptions {
                    unitTests.isIncludeAndroidResources = true
                }
            }
            configureKotlin<KotlinAndroidProjectExtension>()
        }
    }
}
