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

import com.diffplug.gradle.spotless.SpotlessExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class EchoAndroidSpotlessPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.diffplug.spotless")
            }

            extensions.configure<SpotlessExtension> {
                kotlin {
                    target("**/*.kt")
                    targetExclude("**/build/**/*.kt")
                    licenseHeaderFile(
                        rootProject.file("$rootDir/spotless/copyright.kt"),
                        "^(package|object|import|interface|@)",
                    )
                }

                kotlinGradle {
                    target("**/*.gradle.kts")
                    targetExclude("**/build/**/*.kts")
                    licenseHeaderFile(
                        rootProject.file("$rootDir/spotless/copyright.kts"),
                        "(^(?![\\/ ]\\*).*\$)",
                    )
                }

                format("xml") {
                    target("**/*.xml")
                    targetExclude("**/build/**/*.xml")
                    licenseHeaderFile(
                        rootProject.file("$rootDir/spotless/copyright.xml"),
                        "(<[^!?])",
                    )
                }
            }
        }
    }
}
