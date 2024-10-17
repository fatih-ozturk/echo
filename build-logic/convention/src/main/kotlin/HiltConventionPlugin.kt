import echo.app.utils.implementation
import echo.app.utils.ksp
import echo.app.utils.kspAndroidTest
import echo.app.utils.kspTest
import echo.app.utils.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class HiltConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.google.devtools.ksp")
                withPlugin("com.android.base") {
                    pluginManager.apply("dagger.hilt.android.plugin")
                    dependencies {
                        implementation(libs.findLibrary("hilt.android").get())
                    }
                }
            }

            dependencies {
                ksp(libs.findLibrary("hilt.compiler").get())
                kspAndroidTest(libs.findLibrary("hilt.compiler").get())
                kspTest(libs.findLibrary("hilt.compiler").get())
            }
        }
    }
}
