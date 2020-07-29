plugins {
    id("org.jetbrains.kotlin.js")
}

version "1.0.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-js:1.3.72")
    testImplementation("org.jetbrains.kotlin:kotlin-test-js:1.3.72")
}

kotlin.target.browser { }
