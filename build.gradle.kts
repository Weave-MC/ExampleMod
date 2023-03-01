plugins {
    java
}

group = "com.example"
version = "1.0"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    implementation("com.github.Weave-MC:Weave-Loader:6015cdb81f")
}

tasks.compileJava {
    options.release.set(11)
}

tasks.jar {
    manifest.attributes(
        "Weave-Entry" to "com.example.mod.ExampleMod"
    )
}