plugins {
    id("java")
    id("com.github.johnrengelman.shadow") version "7.0.0"
}

group = "pl.tvn24van"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    compileOnly(libs.minestom)
    implementation(project(":api"))
}