// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.0.0" apply false
    id("com.android.library") version "8.0.0" apply false
}
buildscript {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
    dependencies {
        classpath(deps.gradle.hilt)
        classpath(deps.gradle.android)
        classpath(deps.gradle.kotlin)
    }
}
allprojects {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
