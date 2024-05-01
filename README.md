# Weave's Mod Template

This repository shows how to setup a [Gradle](https://gradle.org) project with the [Weave Gradle plugin](https://github.com/Weave-MC/Weave-Gradle) to develop mods for Weave.

## How to start?

To use this repository as a template, click on the green **Use this template** button. 

Alternatively, you can simply clone this repository with the following commands:
```bash
# You can change "MyCoolMod" to anything you'd like
git clone https://github.com/Weave-MC/ExampleMod MyCoolMod 
cd MyCoolMod
```

## How to build

To build a Weave mod, you can simply run:

```bash
./gradlew build
```

You can find the built jar files in `./build/libs/*.jar`.