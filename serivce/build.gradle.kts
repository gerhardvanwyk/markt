import org.gradle.kotlin.dsl.support.compileKotlinScriptModuleTo

project.group = "com.markt"
project.version = "1.0.0-Snapshot"

plugins{
    java
    //Kotlin plugin is applied in the parent
}

dependencies{

}

application {
    // Define the main class for the application.
    mainClassName = "Main"
}
