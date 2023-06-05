@file:Suppress("UnstableApiUsage")

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("kotlin-parcelize")
    kotlin("kapt")
}

android {
    namespace = "com.startup.meetting"
    compileSdk = deps.versions.android.compileSdk.get().toInt()
    defaultConfig {
        applicationId = "com.startup.meetiing"

        minSdk = deps.versions.android.minSdk.get().toInt()
        targetSdk = deps.versions.android.targetSdk.get().toInt()

        versionCode = (property("VERSION_CODE") as String).toInt()
        versionName = property("VERSION_NAME") as String

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables.useSupportLibrary = true
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = deps.versions.compose.compiler.get()
    }
    packaging {
        resources.excludes.addAll(
            listOf(
                "/META-INF/{AL2.0,LGPL2.1}"
            )
        )
    }
}

kapt {
    correctErrorTypes = true
}

dependencies {
    implementation(deps.androidx.core)
    implementation(deps.androidx.core.ktx)
    implementation(deps.androidx.appcompat)
    implementation(deps.androidx.activity.ktx)
    implementation(deps.androidx.fragment.ktx)
    implementation(deps.androidx.annotation)

    implementation(deps.lifecycle.ktx)
    implementation(deps.lifecycle.testing)
    implementation(deps.lifecycle.common.java8)
    implementation(deps.lifecycle.viewmodel.ktx)

    implementation(deps.kotlin.stdlib.jdk8)

    implementation(deps.coroutine.core)
    implementation(deps.coroutine.android)
    implementation(deps.coroutine.test)

    implementation(platform(deps.compose.bom))
    implementation(deps.bundles.compose)
    implementation(deps.compose.ui)
    implementation(deps.compose.ui.graphics)
    implementation(deps.compose.ui.preview)
    implementation(deps.compose.material3)
    implementation(deps.compose.activity)
    implementation(deps.compose.animation)
    implementation(deps.compose.foundation)
    implementation(deps.compose.constraintlayout)
    debugImplementation(deps.compose.ui.tooling)
    debugImplementation(deps.compose.ui.test.manifest)

    implementation(deps.retrofit)
    implementation(deps.retrofit.converter.gson)
    implementation(deps.okhttp)
    implementation(deps.okhttp.logging.interceptor)
    implementation(deps.gson)

    testImplementation(deps.test.junit)
    androidTestImplementation(deps.test.androidx.espresso.core)

    implementation(deps.room)
    implementation(deps.room.ktx)
    kapt(deps.room.compiler)

    implementation(deps.hilt)
    kapt(deps.hilt.compiler)
}
