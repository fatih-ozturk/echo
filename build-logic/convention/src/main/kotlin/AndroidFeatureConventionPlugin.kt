import echo.app.utils.androidTestImplementation
import echo.app.utils.implementation
import echo.app.utils.libs
import echo.app.utils.testImplementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.kotlin

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("echo.android.library")
                apply("echo.android.hilt")
                apply("echo.kotlin.serialization")
                apply("echo.spotless")
                apply("echo.ktlint")
                apply("echo.detekt")
            }

            dependencies {
//                implementation(project(":core:base"))
//                implementation(project(":core:common-ui"))
//                implementation(project(":core:designsystem"))
//                implementation(project(":core:data"))
//                implementation(project(":core:localization"))
//                implementation(project(":core:model"))
//                implementation(project(":core:screens"))

                testImplementation(kotlin("test"))
                androidTestImplementation(kotlin("test"))
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
