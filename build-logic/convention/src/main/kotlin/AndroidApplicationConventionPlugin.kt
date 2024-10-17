import echo.app.Versions
import com.android.build.api.dsl.ApplicationExtension
import echo.app.configureKotlinAndroid
import echo.app.registerPrePushTask
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
                apply("echo.kotlin.serialization")
            }

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = Versions.TARGET_SDK
            }
            registerPrePushTask()
        }
    }
}
