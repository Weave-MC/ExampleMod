import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.9.23"
    id("net.weavemc.gradle") version "1.1.0"
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
    mavenCentral()
    mavenLocal()
    maven("https://repo.spongepowered.org/maven/")
    // Check available packages at https://gitlab.com/weave-mc/weave/-/packages/
    maven("https://gitlab.com/api/v4/projects/80566527/packages/maven")
}

dependencies {
    implementation("net.weavemc:loader:1.1.0") // For advanced modifications
    implementation("net.weavemc:internals:1.1.0")
    implementation("net.weavemc.api:api:1.1.0")
    implementation("net.weavemc.api:api-v1_8:1.1.0") // For 1.8 events

    compileOnly("org.spongepowered:mixin:0.8.5")

    implementation(kotlin("stdlib", "1.9.23"))
    implementation(kotlin("stdlib-jdk7", "1.9.23"))
    implementation(kotlin("stdlib-jdk8", "1.9.23"))
}

configurations.all {
    resolutionStrategy {
        force("org.jetbrains.kotlin:kotlin-stdlib:1.9.23")
        force("org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.9.23")
        force("org.jetbrains.kotlin:kotlin-stdlib-jdk8:1.9.23")
    }
}

java {
    withSourcesJar()

    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
    }
}
