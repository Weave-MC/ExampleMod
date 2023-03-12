plugins {
    java
    id("com.github.weave-mc.weave") version "7cc0e879eb"
}

group = "com.example"
version = "1.0"

minecraft.version.set("1.8.9")

repositories {
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("com.github.Weave-MC:Weave-Loader:f736ac0323")
}

tasks.compileJava {
    options.release.set(11)
}

tasks.jar {
    manifest.attributes(
        "Weave-Entry" to "com.example.mod.ExampleMod"
    )
}
