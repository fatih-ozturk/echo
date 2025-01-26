import echo.app.utils.implementation
import echo.app.utils.ksp
import echo.app.utils.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidRoomConventionPlugin : Plugin<Project> {

    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.google.devtools.ksp")
            }

            dependencies {
                implementation(libs.findLibrary("room.runtime").get())
                implementation(libs.findLibrary("room.ktx").get())
                ksp(libs.findLibrary("room.compiler").get())
            }
        }
    }
}
