plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.serialization) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.secrets) apply false
    alias(libs.plugins.detekt) apply false
    alias(libs.plugins.compose) apply false
    alias(libs.plugins.spotless) apply false
    alias(libs.plugins.paparazzi) apply false
    alias(libs.plugins.dependencyGuard) apply false
    alias(libs.plugins.kover) apply false
}
