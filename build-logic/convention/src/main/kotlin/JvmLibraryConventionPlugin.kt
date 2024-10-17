import echo.app.configureKotlinJvm
import org.gradle.api.Plugin
import org.gradle.api.Project

class JvmLibraryConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlin.jvm")
                apply("echo.kotlin.serialization")
                apply("echo.spotless")
                apply("echo.ktlint")
                apply("echo.detekt")
            }
            configureKotlinJvm()
        }
    }
}
