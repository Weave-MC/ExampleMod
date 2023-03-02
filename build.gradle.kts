plugins {
    java
    id("com.github.weave-mc.weave") version "3ad11a0fd5"
}

group = "com.example"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.Weave-MC:Weave-Loader:4c45210e52")
}

tasks.compileJava {
    options.release.set(11)
}

tasks.jar {
    manifest.attributes(
        "Weave-Entry" to "com.example.mod.ExampleMod"
    )
}

minecraft {
    version = "1.8.9"
    mappings = "stable_22"
}