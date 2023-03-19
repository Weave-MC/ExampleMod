plugins {
    java
    id("com.github.weave-mc.weave") version "8b70bcc707"
}

group = "com.example"
version = "1.0"

minecraft.version("1.8.9")

repositories {
    maven("https://jitpack.io")
}

dependencies {
    compileOnly("com.github.Weave-MC:Weave-Loader:454f9a8cca")
}

tasks.compileJava {
    options.release.set(11)
}

tasks.jar {
    manifest.attributes(
        "Weave-Entry" to "com.example.mod.ExampleMod"
    )
}
