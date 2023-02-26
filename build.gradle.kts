plugins {
    kotlin("jvm") version "1.8.0"
}

group = "com.example"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.Weave-MC:Weave-Api:eaa143c17b")
}

tasks.jar {
    manifest.attributes(
        "Weave-Entry" to "com.example.mod.Entry"
    )
}