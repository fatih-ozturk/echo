import echo.app.utils.ktlintRuleset
import echo.app.utils.libs
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies
import org.jlleitschuh.gradle.ktlint.KtlintExtension
import org.jlleitschuh.gradle.ktlint.reporter.ReporterType

class AndroidKtlintConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.jlleitschuh.gradle.ktlint")
            }

            extensions.configure<KtlintExtension> {
                android.set(true)
                filter {
                    exclude("**/generated/**")
                    include("**/kotlin/**")
                }
                reporters {
                    reporter(ReporterType.HTML)
                }
            }

            dependencies {
                ktlintRuleset(libs.findLibrary("ktlint.ruleset.compose").get())
            }
        }
    }
}
