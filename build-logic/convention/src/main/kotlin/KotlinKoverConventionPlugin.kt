import echo.app.configureKotlinKover
import com.android.build.api.variant.ApplicationAndroidComponentsExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class KotlinKoverConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jetbrains.kotlinx.kover")
            }
            val extension = extensions.getByType<ApplicationAndroidComponentsExtension>()
            configureKotlinKover(extension)
        }
    }
}
