package echo.app

import com.android.build.api.variant.AndroidComponentsExtension
import kotlinx.kover.gradle.plugin.dsl.KoverProjectExtension
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

internal fun Project.configureKotlinKover(
    androidComponentsExtension: AndroidComponentsExtension<*, *, *>,
) {
    androidComponentsExtension.onVariants { variant ->
        configure<KoverProjectExtension> {
            reports {
                variant(variant.name) {
                    filters {
                        excludes {
                            // TODO
                        }
                    }
                }
            }
        }
    }
}
