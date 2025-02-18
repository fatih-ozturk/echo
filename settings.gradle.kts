@file:Suppress("UnstableApiUsage")
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://jitpack.io")
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        maven("https://jitpack.io")
    }
}

rootProject.name = "Echo"
include(":app")
include(":core:common")
include(":core:data")
include(":core:database")
include(":core:domain")
include(":core:network")
include(":core:presentation")
include(":designsystem:chroma")
include(":feature-authentication:data")
include(":feature-authentication:domain")
include(":feature-authentication:presentation")
include(":feature-home:data")
include(":feature-home:domain")
include(":feature-home:presentation")
include(":feature-splash:presentation")
include(":account:api")
include(":account:impl")
include(":security-crypto:api")
include(":security-crypto:impl")
include(":app-config:api")
