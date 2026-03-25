pluginManagement {
    repositories {
        gradlePluginPortal()
        // Check available packages at https://gitlab.com/weave-mc/weave/-/packages/
        maven("https://gitlab.com/api/v4/projects/80566527/packages/maven")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.+"
}

rootProject.name = "ExampleMod"