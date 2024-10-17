package echo.app

import echo.app.utils.libs
import com.android.build.api.dsl.CommonExtension
import echo.app.utils.androidTestImplementation
import echo.app.utils.debugImplementation
import echo.app.utils.implementation
import echo.app.utils.testImplementation
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
            // Add ComponentActivity to debug manifest
            debugImplementation(libs.findLibrary("androidx.compose.ui.testManifest").get())
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
            freeCompilerArgs.add("-opt-in=androidx.compose.foundation.ExperimentalFoundationApi")
        }
    }
}
