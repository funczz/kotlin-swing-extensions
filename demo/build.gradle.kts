/**
 * plugins
 */
plugins {
    application
}

/**
 * plugin: application
 */
application {
    mainClass.set(System.getProperty("mainClass") ?: "")
}

/**
 * buildscript
 */
buildscript {
    dependencies {
    }
}

/**
 * dependencies
 */
dependencies {
    implementation(project(":swing-extensions"))
}
