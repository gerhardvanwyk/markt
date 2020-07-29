

plugins {
    id("com.android.application")
    id("kotlin-android")
    id("kotlin-android-extensions")
  //  id("androidx.navigation.safeargs")
}

repositories {
    google()
    jcenter()
    mavenCentral()
    maven("https://repo1.maven.org/maven2/")
    mavenLocal()
}

android {
    compileSdkVersion(30)
    buildToolsVersion = "29.0.2"
    defaultConfig {
        applicationId = "com.markt"
        minSdkVersion(27)
        targetSdkVersion(30)
        versionCode = 1
        versionName = "1.0"
        testInstrumentationRunner = "android.support.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled  = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {

    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    val kotlinVersion = "1.3.72"
    implementation("org.jetbrains.kotlin:kotlin-android-extensions-runtime:$kotlinVersion")
    implementation("org.jetbrains.kotlin:kotlin-compiler-embeddable:$kotlinVersion")

    debugApi("org.jetbrains.kotlin:kotlin-android-extensions-runtime:$kotlinVersion")

    implementation("androidx.core:core-ktx:1.3.0")
    implementation("androidx.appcompat:appcompat:1.1.0")
    implementation("androidx.constraintlayout:constraintlayout:2.0.0-beta7")

    //-- Navigation dependencies
    val navVersion = "2.3.0"
    // Java language implementation
    implementation("androidx.navigation:navigation-fragment:$navVersion")
    implementation("androidx.navigation:navigation-ui:$navVersion")

    //Dagger dependency injector
    compileOnly("com.google.dagger:dagger:2.28.3")

    //Annotation
    annotationProcessor("com.google.dagger:dagger-compiler:2.28.3")

    // Kotlin
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation ("androidx.navigation:navigation-ui-ktx:$navVersion")

    // Dynamic Feature Module Support
    implementation("androidx.navigation:navigation-dynamic-features-fragment:$navVersion")

    // Testing Navigation
    androidTestImplementation("androidx.navigation:navigation-testing:$navVersion")
    androidTestImplementation("androidx.test:runner:1.2.0")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.2.0")

    val jUnitVersion = "5.6.2"

    implementation("org.junit.jupiter:junit-jupiter:$jUnitVersion")
//    implementation("org.junit.jupiter:junit-jupiter:$jUnitVersion:sources")
    implementation(platform("org.jetbrains.kotlin:kotlin-bom:$kotlinVersion"))
//    implementation(platform("org.jetbrains.kotlin:kotlin-bom:$kotlinVersion:sources"))
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
//    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion:sources")

    testImplementation("org.junit.jupiter:junit-jupiter:$jUnitVersion")
    testImplementation("org.jetbrains.kotlin:kotlin-test:$kotlinVersion")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlinVersion")
}
