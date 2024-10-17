import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    `kotlin-dsl`
}

group = "echo.app.buildlogic"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}
tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }
}

dependencies {
    compileOnly(libs.android.gradlePlugin)
    compileOnly(libs.kotlin.gradlePlugin)
    compileOnly(libs.ksp.gradlePlugin)
    compileOnly(libs.detekt.gradlePlugin)
    compileOnly(libs.spotless.gradlePlugin)
    compileOnly(libs.ktlint.gradlePlugin)
    compileOnly(libs.compose.gradlePlugin)
    compileOnly(libs.kover.gradlePlugin)
}

gradlePlugin {
    plugins {
        register("androidApplicationCompose") {
            id = "echo.android.application.compose"
            implementationClass = "AndroidApplicationComposeConventionPlugin"
        }
        register("androidApplication") {
            id = "echo.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }
        register("androidLibraryCompose") {
            id = "echo.android.library.compose"
            implementationClass = "AndroidLibraryComposeConventionPlugin"
        }
        register("androidLibrary") {
            id = "echo.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }
        register("androidFeature") {
            id = "echo.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
        register("androidHilt") {
            id = "echo.hilt"
            implementationClass = "HiltConventionPlugin"
        }
        register("androidRoom") {
            id = "echo.android.room"
            implementationClass = "AndroidRoomConventionPlugin"
        }
        register("androidDetekt") {
            id = "echo.detekt"
            implementationClass = "AndroidDetektConventionPlugin"
        }
        register("androidSpotless") {
            id = "echo.spotless"
            implementationClass = "AndroidSpotlessConventionPlugin"
        }
        register("androidKtlint") {
            id = "echo.ktlint"
            implementationClass = "AndroidKtlintConventionPlugin"
        }
        register("kotlinSerialization") {
            id = "echo.kotlin.serialization"
            implementationClass = "KotlinSerializationConventionPlugin"
        }
        register("kotlinKover") {
            id = "echo.kotlin.kover"
            implementationClass = "KotlinKoverConventionPlugin"
        }
        register("jvmLibrary") {
            id = "echo.jvm.library"
            implementationClass = "JvmLibraryConventionPlugin"
        }
    }
}
