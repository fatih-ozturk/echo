package echo.app.utils

import org.gradle.api.Project
import org.gradle.kotlin.dsl.support.uppercaseFirstChar
import java.io.File

internal fun Project.registerFeatureCreatorTask() {
    tasks.register("createFeature") {
        group = "module management"
        description = "Create a new feature with data, domain and presentation submodules"

        doLast {
            val featureName = project.findProperty("featureName") as? String
                ?: error("Please provide a featureName property, e.g., -PfeatureName=auth")

            createModuleStructure(featureName)
        }
    }
}

private fun Project.createModuleStructure(featureName: String) {
    val baseDir = File(rootProject.projectDir, "feature-$featureName")
    val dataDir = File(baseDir, "data")
    val domainDir = File(baseDir, "domain")
    val presentationDir = File(baseDir, "presentation")

    createDirectories(dataDir, domainDir, presentationDir, featureName)
    createDataBuildFile(dataDir, featureName)
    createDomainBuildFile(domainDir)
    createPresentationBuildFile(presentationDir, featureName)
    createGitignoreFiles(dataDir, domainDir, presentationDir)
    updateSettingsFile(featureName)

    println("Created $featureName modules successfully!")
    println("Please sync your project with Gradle files")
}

private fun createDirectories(
    dataDir: File,
    domainDir: File,
    presentationDir: File,
    featureName: String
) {
    listOf(
        dataDir.parentFile,
        dataDir,
        domainDir,
        presentationDir
    ).forEach { it.mkdirs() }

    listOf(
        File(dataDir, "src/main/kotlin/echo/app/$featureName/data"),
        File(domainDir, "src/main/kotlin/echo/app/$featureName/domain"),
        File(presentationDir, "src/main/kotlin/echo/app/$featureName/presentation"),
        File(presentationDir, "src/main/res")
    ).forEach { it.mkdirs() }
}

private fun createDataBuildFile(dataDir: File, featureName: String) {
    File(dataDir, "build.gradle.kts").writeText(
        """
    plugins {
        id("echo.android.library")
        id("echo.android.room")
        id("echo.hilt")
    }

    android {
        namespace = "echo.app.${featureName}.data"
    }

    dependencies {
        implementation(projects.core.data)
        implementation(projects.core.database)
        implementation(projects.core.domain)
        implementation(projects.core.network)
        implementation(projects.feature${featureName.uppercaseFirstChar()}.domain)
        implementation(projects.account.api)
    }
    
    """.trimIndent()
    )
}

private fun createDomainBuildFile(domainDir: File) {
    File(domainDir, "build.gradle.kts").writeText(
        """
    plugins {
       id("echo.jvm.library")
    }
    
    dependencies {
        implementation(projects.core.domain)
    
        implementation(libs.arrow.core)
    }

    """.trimIndent()
    )
}

private fun createPresentationBuildFile(presentationDir: File, featureName: String) {
    File(presentationDir, "build.gradle.kts").writeText(
        """
    plugins {
        id("echo.android.feature")
        id("echo.android.library.compose")
    }
    
    android {
        namespace = "echo.app.${featureName}.presentation"
    }
    
    dependencies {
        implementation(projects.core.domain)
        implementation(projects.core.presentation)
        implementation(projects.feature${featureName.uppercaseFirstChar()}.domain)
        implementation(projects.designsystem.chroma)
        implementation(libs.androidx.browser)
        implementation(libs.arrow.core)
    }

    """.trimIndent()
    )
}

private fun createGitignoreFiles(dataDir: File, domainDir: File, presentationDir: File) {
    File(dataDir, ".gitignore").writeText("/build")
    File(domainDir, ".gitignore").writeText("/build")
    File(presentationDir, ".gitignore").writeText("/build")
}

private fun Project.updateSettingsFile(featureName: String) {
    val settingsFile = File(rootProject.projectDir, "settings.gradle.kts")
    val settingsContent = settingsFile.readText()
    val moduleRegistration = """
    include(":feature-${featureName}:data")
    include(":feature-${featureName}:domain")
    include(":feature-${featureName}:presentation")
    
    """.trimIndent()

    settingsFile.writeText(settingsContent + moduleRegistration)
}
