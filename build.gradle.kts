plugins {
    java
    id("com.github.weave-mc.weave") version "ec59a8bceb"
}

group = "com.example"
version = "1.0"

minecraft.version.set("1.8.9")

tasks.compileJava {
    options.release.set(11)
}

tasks.jar {
    manifest.attributes(
        "Weave-Entry" to "com.example.mod.ExampleMod"
    )
}
