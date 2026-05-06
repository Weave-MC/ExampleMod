# Weave's Mod Template

This repository shows how to set up a [Gradle](https://gradle.org) project using the [Weave Gradle plugin](https://github.com/Weave-MC/Weave-Gradle) to develop mods for Weave.
This template uses Java, if you want to use Kotlin instead, check out the [Kotlin Template](https://github.com/Weave-MC/example-mod-kotlin).

## How to start?

To use this repository as a template, click on the green **Use this template** button. 

Alternatively, you can simply clone this repository with the following commands:
```bash
# You can change "MyCoolMod" to anything you'd like
git clone https://github.com/Weave-MC/ExampleMod MyCoolMod 
cd MyCoolMod
```

## How to build

Building requires a JDK of version 17 or higher. A good JDK distribution can be downloaded from [Adoptium.net](https://adoptium.net/temurin/releases?version=17&os=any&arch=any), but any OpenJDK compatible JDK suffices.

To build a Weave mod, you can simply run:

```bash
./gradlew build
```

You can find the built jar files in `./build/libs/*.jar`.
