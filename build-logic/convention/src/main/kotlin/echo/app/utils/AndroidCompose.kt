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
package echo.app.utils

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.assign
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.withType
import org.jetbrains.kotlin.compose.compiler.gradle.ComposeCompilerGradlePluginExtension
import org.jetbrains.kotlin.compose.compiler.gradle.ComposeFeatureFlag
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import java.io.File

internal fun Project.configureAndroidCompose(
    commonExtension: CommonExtension<*, *, *, *, *, *>,
) {
    commonExtension.apply {
        buildFeatures {
            compose = true
        }

        dependencies {
            val bom = libs.findLibrary("androidx-compose-bom").get()
            implementation(platform(bom))
            androidTestImplementation(platform(bom))
            implementation(libs.findLibrary("androidx-compose-ui-tooling-preview").get())
            debugImplementation(libs.findLibrary("androidx-compose-ui-tooling").get())
        }
    }
    with(extensions.getByType<ComposeCompilerGradlePluginExtension>()) {
        val metricsFolder = File(project.layout.buildDirectory.asFile.get(), "compose-metrics")
        val reportsFolder = File(project.layout.buildDirectory.asFile.get(), "compose-reports")
        featureFlags = setOf(
            ComposeFeatureFlag.StrongSkipping.disabled(),
            ComposeFeatureFlag.OptimizeNonSkippingGroups
        )
        includeSourceInformation.set(true)
        metricsDestination.set(metricsFolder)
        reportsDestination.set(reportsFolder)
        includeTraceMarkers.set(true)
    }

    tasks.withType<KotlinCompile>().configureEach {
        compilerOptions {
            optIn.add("androidx.compose.foundation.ExperimentalFoundationApi")
        }
    }
}
