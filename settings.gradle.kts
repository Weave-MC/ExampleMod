pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://repo.weavemc.net/releases")
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.+"
}

rootProject.name = "ExampleMod"
