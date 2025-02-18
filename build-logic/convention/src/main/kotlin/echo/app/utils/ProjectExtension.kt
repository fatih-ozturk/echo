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
package echo.app.utils

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.api.dsl.LibraryExtension
import kotlinx.kover.gradle.plugin.dsl.KoverProjectExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.getByType

internal val Project.libs: VersionCatalog
    get() = extensions.getByType<VersionCatalogsExtension>().named("libs")

internal fun Project.configureAndroidApplication(
    configure: ApplicationExtension.() -> Unit,
) = extensions.configure<ApplicationExtension> {
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    configure()
}

internal fun Project.configureAndroidLibrary(
    configure: LibraryExtension.() -> Unit,
) = extensions.configure<LibraryExtension> {
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    configure()
}

internal fun Project.configureKover() {
    rootProject.subprojects.forEach { subproject ->
        if (subproject.pluginManager.hasPlugin("org.jetbrains.kotlin.plugin.compose")) return@forEach
        subproject.pluginManager.withPlugin("org.jetbrains.kotlinx.kover") {
            dependencies.kover(project(subproject.path))
        }
    }

    configure<KoverProjectExtension> {
        reports {
            filters {
                excludes {
                    androidGeneratedClasses()
                    annotatedBy("androidx.compose.ui.tooling.preview.Preview")
                    annotatedBy("Generated")
                    packages(
                        "dagger.hilt.*",
                        "hilt_aggregated_deps",
                        "*.model",
                        "echo.app.chroma*",
                        "echo.app.core*",
                        "*.di",
                        "*.navigation",
                    )
                    classes(
                        "Hilt_*",
                        "*_Factory",
                        "*_HiltModules*",
                        "*_Provide*Factory*",
                        "*Module*.*",
                        "*Dagger*.*",
                        "*Hilt*.*",
                        "*_HiltModules*",
                        "*MembersInjector*.*",
                        "*_MembersInjector.class",
                        "*_Factory*.*",
                        "*_Factory\$*",
                        "*.*ComposableSingletons*",
                        "*.*NavigationKt*",
                        "*.dao.*Dao*",
                        "*.entity.*Entity*",
                        "*.database.*Database*",
                    )
                }
            }
        }
    }
}
