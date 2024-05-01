plugins {
    id("net.weavemc.gradle") version "1.0.0-PRE"
}

group = "com.example"
version = "1.0.0"

minecraft {
    configure {
        name = "ExampleMod"
        modId = "examplemod"
        entryPoints = listOf("com.example.mod.ExampleMod")
        mixinConfigs = listOf("examplemod.mixins.json")
        mcpMappings()
    }
    version("1.8.9")
}

repositories {
    maven("https://repo.weavemc.dev/releases")
    maven("https://repo.spongepowered.org/maven/")
}

dependencies {
    compileOnly("net.weavemc.api:common:1.0.0-b.2")
    compileOnly("org.spongepowered:mixin:0.8.5")
}

java {
    withSourcesJar()

    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}