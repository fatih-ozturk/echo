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
import echo.app.utils.detektPlugins
import echo.app.utils.libs
import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType

class EchoAndroidDetektPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("io.gitlab.arturbosch.detekt")
            }

            configure<DetektExtension> {
                autoCorrect = true
                source.setFrom(
                    project.files(project.file(project.rootDir)),
                )
                config.setFrom(project.rootProject.files("config/detekt/detekt.yml"))
                baseline = project.rootProject.file("config/detekt/baseline.xml")
            }

            tasks.withType<Detekt>().configureEach {
                jvmTarget = JavaVersion.VERSION_17.toString()

                exclude(
                    "**/.gradle/**",
                    "**/.idea/**",
                    "**/build/**",
                    ".github/**",
                    "gradle/**",
                )

                reports {
                    html.required.set(true)
                    xml.required.set(false)
                    md.required.set(false)
                    txt.required.set(false)
                    sarif.required.set(false)
                }
            }

            tasks.withType<DetektCreateBaselineTask>().configureEach {
                exclude(
                    "**/.gradle/**",
                    "**/.idea/**",
                    "**/build/**",
                    ".github/**",
                    "gradle/**",
                    "**/spotless/**",
                )
            }

            dependencies {
                detektPlugins(libs.findLibrary("detekt.ruleset.compose").get())
                detektPlugins(libs.findLibrary("detekt.formatting").get())
            }
        }
    }
}
