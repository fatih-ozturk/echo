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
import echo.app.utils.implementation
import echo.app.utils.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class EchoAndroidFeaturePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("echo.android.library.compose")
                apply("echo.hilt")
                apply("echo.serialization")
            }

            dependencies {
                implementation(project(":core:domain"))
                implementation(project(":core:presentation"))

                implementation(libs.findLibrary("timber").get())
                implementation(libs.findLibrary("coil.kt.compose").get())

                implementation(libs.findLibrary("androidx.navigation.compose").get())
                implementation(libs.findLibrary("androidx.hilt.navigation.compose").get())
                implementation(libs.findLibrary("androidx.lifecycle.runtimeCompose").get())
                implementation(libs.findLibrary("androidx.lifecycle.viewModelCompose").get())

                implementation(libs.findLibrary("kotlinx.coroutines.android").get())
                implementation(libs.findLibrary("kotlinx.collections.immutable").get())
            }
        }
    }
}
