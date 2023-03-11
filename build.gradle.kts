plugins {
    java
    id("com.github.weave-mc.weave") version "85846a675a"
}

group = "com.example"
version = "1.0"

repositories {
    mavenCentral()
    mavenLocal()
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.weave-mc:Weave-Loader:e92617f4e2")
}

minecraft {
    version.set("1.8.9")
}

tasks.compileJava {
    options.release.set(11)
}

tasks.jar {
    manifest.attributes(
        "Weave-Entry" to "com.example.mod.ExampleMod"
    )
}
