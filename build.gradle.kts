plugins {
    id("net.weavemc.gradle") version "1.2.0"
}

group = "com.example"
version = "1.0.0"

weave {
    configure {
        name = "ExampleMod"
        modId = "examplemod"
        entryPoints = listOf("com.example.mod.ExampleMod")
        hooks = listOf("com.example.mod.hook.MinecraftHook")
        mixinConfigs = listOf("examplemod.mixins.json")
        accessWideners = listOf("examplemod.accesswidener.txt")
        mcpMappings()
    }
    version("1.8.9")
}

repositories {
    maven("https://repo.spongepowered.org/maven/")
    // Check available packages at https://gitlab.com/weave-mc/weave/-/packages/
    maven("https://gitlab.com/api/v4/projects/80566527/packages/maven")
}

var weaveVersion = "1.2.0"
dependencies {
    implementation("net.weavemc:loader:$weaveVersion") // For advanced modifications
    implementation("net.weavemc:internals:$weaveVersion")
    implementation("net.weavemc.api:api:$weaveVersion")
    implementation("net.weavemc.api:api-v1_8:$weaveVersion") // For 1.8 events

    compileOnly("org.spongepowered:mixin:0.8.5")
}

java {
    withSourcesJar()

    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}