import echo.app.utils.detektPlugins
import echo.app.utils.libs
import io.gitlab.arturbosch.detekt.Detekt
import io.gitlab.arturbosch.detekt.DetektCreateBaselineTask
import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.withType

class AndroidDetektConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("io.gitlab.arturbosch.detekt")
            }

            configure<DetektExtension> {
                autoCorrect = true
                source.setFrom(
                    project.files(project.file(project.rootDir)),
                )
                config.setFrom(project.rootProject.files("config/detekt/detekt.yml"))
                baseline = project.rootProject.file("config/detekt/baseline.xml")
            }

            tasks.withType<Detekt>().configureEach {
                jvmTarget = JavaVersion.VERSION_17.toString()

                exclude(
                    "**/.gradle/**",
                    "**/.idea/**",
                    "**/build/**",
                    ".github/**",
                    "gradle/**",
                )

                reports {
                    html.required.set(true)
                    xml.required.set(false)
                    md.required.set(false)
                    txt.required.set(false)
                    sarif.required.set(false)
                }
            }

            tasks.withType<DetektCreateBaselineTask>().configureEach {
                exclude(
                    "**/.gradle/**",
                    "**/.idea/**",
                    "**/build/**",
                    ".github/**",
                    "gradle/**",
                    "**/spotless/**",
                )
            }

            dependencies {
                detektPlugins(libs.findLibrary("detekt.ruleset.compose").get())
            }
        }
    }
}
