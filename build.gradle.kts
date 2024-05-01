plugins {
    java
    id("com.github.weave-mc.weave-gradle") version "649dba7468"
}

group = "com.example"
version = "1.0.0"

minecraft.version("1.8.9")

repositories {
    maven("https://jitpack.io") {
        name = "WeaveMC's Jitpack"
        content {
            includeGroup("com.github.weave-mc")
        }
    }
    maven("https://repo.spongepowered.org/maven/")
}

dependencies {
    compileOnly("com.github.weave-mc:weave-loader:v0.2.4")

    compileOnly("org.spongepowered:mixin:0.8.5")
}

java {
    withSourcesJar()

    toolchain {
        languageVersion.set(JavaLanguageVersion.of(8))
    }
}