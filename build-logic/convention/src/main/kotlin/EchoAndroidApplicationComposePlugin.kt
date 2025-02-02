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
import com.android.build.api.dsl.ApplicationExtension
import echo.app.utils.configureAndroidCompose
import echo.app.utils.configureKotlin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import org.jetbrains.kotlin.gradle.dsl.KotlinAndroidProjectExtension

class EchoAndroidApplicationComposePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("echo.android.application")
                apply("org.jetbrains.kotlin.plugin.compose")
                apply("org.jetbrains.kotlin.android")
                apply("echo.hilt")
                apply("echo.android.room")
                apply("echo.detekt")
                apply("echo.spotless")
                apply("echo.dependencyGuard")
            }

            val extension = extensions.getByType<ApplicationExtension>()
            configureAndroidCompose(extension)
            configureKotlin<KotlinAndroidProjectExtension>()
        }
    }
}
