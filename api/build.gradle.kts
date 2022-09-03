plugins {
    id("java")
}

group = "pl.tvn24van"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    maven("https://jitpack.io")
}

dependencies {
    compileOnly(libs.minestom)

    testImplementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
}

tasks.getByName<Test>("test") {
    useJUnitPlatform()
}