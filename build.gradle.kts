import org.jetbrains.kotlin.config.KotlinCompilerVersion

plugins {
    // Apply the Kotlin JVM plugin to add support for Kotlin.
    kotlin("jvm") version "1.3.72"

    idea

    // Apply the application plugin to add support for building a CLI application.
    application
}

/**
 * By default, the top-level build file uses the buildscript block to define the Gradle repositories and dependencies
 * that are common to all modules in the project. The buildscript block is where you configure the repositories and
 * dependencies for Gradle itself—meaning, you should not include dependencies for your modules here. For example, this
 * block includes the Android plugin for Gradle as a dependency because it provides the additional instructions Gradle
 * needs to build Android app modules.
 */
buildscript{

    val navVersion = "2.3.0" //See app build script

    /**
     * The repositories block configures the repositories Gradle uses to
     * search or download the dependencies. Gradle pre-configures support for remote
     * repositories such as JCenter, Maven Central, and Ivy. You can also use local
     * repositories or define your own remote repositories. The code below defines
     * JCenter as the repository Gradle should use to look for its dependencies.
     *
     * New projects created using Android Studio 4.0 and higher also include
     * Google's Maven repository.
     */
    repositories {
        google()
        jcenter()
        mavenCentral()
        mavenLocal()
    }

    /**
     * The dependencies block configures the dependencies Gradle needs to use
     * to build your project. The following line adds Android plugin for Gradle
     * version 4.0.0 as a classpath dependency.
     */
    dependencies {
        classpath("com.android.tools.build:gradle:4.1.0-beta05")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.72:sources")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$navVersion")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:$navVersion:sources")
    }
}

/**
 * The allprojects block is where you configure the repositories and
 * dependencies used by all modules in your project, such as third-party plugins
 * or libraries. However, you should configure module-specific dependencies in
 * each module-level build.gradle file. For new projects, Android Studio
 * includes JCenter and Google's Maven repository by default, but it does not
 * configure any dependencies (unless you select a template that requires some).
 */
allprojects {
    repositories {
        google()
        jcenter()
        mavenCentral()
        mavenLocal()
    }
}

// This block encapsulates custom properties and makes them available to all
// modules in the project.
ext {
    set("compileSkdVersion", "29.0.2")
    set("android.useAndroidX", true)
}


