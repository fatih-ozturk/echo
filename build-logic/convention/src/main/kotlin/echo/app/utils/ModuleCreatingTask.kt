package echo.app.utils

import org.gradle.api.Project
import java.io.File

internal fun Project.registerModuleCreatorTask() {
    tasks.register("createModule") {
        group = "module management"
        description = "Create a new module with API and Implementation submodules"

        doLast {
            val featureName = project.findProperty("moduleName") as? String
                ?: error("Please provide a moduleName property, e.g., -PmoduleName=auth")

            createModuleStructure(featureName)
        }
    }
}

private fun Project.createModuleStructure(featureName: String) {
    val baseDir = File(rootProject.projectDir, featureName)
    val apiDir = File(baseDir, "api")
    val implementationDir = File(baseDir, "impl")

    createDirectories(apiDir, implementationDir, featureName)
    createApiBuildFile(apiDir)
    createImplementationBuildFile(implementationDir, featureName)
    createGitignoreFiles(apiDir, implementationDir)
    updateSettingsFile(featureName)

    println("Created $featureName modules successfully!")
    println("Please sync your project with Gradle files")
}

private fun createDirectories(apiDir: File, implementationDir: File, featureName: String) {
    listOf(apiDir.parentFile, apiDir, implementationDir).forEach { it.mkdirs() }

    listOf(
        File(apiDir, "src/main/kotlin/echo/app/$featureName/api"),
        File(implementationDir, "src/main/kotlin/echo/app/$featureName/impl")
    ).forEach { it.mkdirs() }
}

private fun createApiBuildFile(apiDir: File) {
    File(apiDir, "build.gradle.kts").writeText("""
    plugins {
        id("echo.jvm.library")
    }

    dependencies {
        implementation(projects.core.domain)
        implementation(libs.arrow.core)
    }
    """.trimIndent())
}

private fun createImplementationBuildFile(implementationDir: File, featureName: String) {
    File(implementationDir, "build.gradle.kts").writeText("""
    plugins {
        id("echo.android.library")
        id("echo.android.room")
        id("echo.hilt")
    }

    android {
        namespace = "echo.app.${featureName}.impl"
    }

    dependencies {
        implementation(projects.core.data)
        implementation(projects.core.database)
        implementation(projects.core.domain)
        implementation(projects.core.network)
        implementation(projects.${featureName}.api)
        implementation(libs.arrow.core)
        implementation(libs.timber)
    }
    """.trimIndent())
}

private fun createGitignoreFiles(apiDir: File, implementationDir: File) {
    File(apiDir, ".gitignore").writeText("/build")
    File(implementationDir, ".gitignore").writeText("/build")
}

private fun Project.updateSettingsFile(featureName: String) {
    val settingsFile = File(rootProject.projectDir, "settings.gradle.kts")
    val settingsContent = settingsFile.readText()
    val moduleRegistration = """
    include(":$featureName:api")
    include(":$featureName:impl")
    
    """.trimIndent()

    settingsFile.writeText(settingsContent + moduleRegistration)
}
