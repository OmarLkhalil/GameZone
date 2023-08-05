@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlinKapt)

}

android {
    compileSdk = 33
    namespace = "com.mobilebreakero.Gamezone"
    defaultConfig {
        applicationId = "com.mobilebreakero.Gamezone"
        minSdk = 24
        targetSdk = 33
        versionCode = 11
        versionName = "1.0"
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }
    buildTypes {
        getByName("release") {

            isMinifyEnabled = true
            isShrinkResources = true
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    configurations {
        implementation {
            resolutionStrategy.failOnVersionConflict()
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
        kotlinCompilerExtensionVersion = "1.4.4"
    }

    kapt {
        correctErrorTypes = true
    }

    with(packagingOptions) {
        resources {
            excludes.add("META-INF/gradle/incremental.annotation.processors")
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
            excludes.add("META-INF/LICENSE.txt")
        }
    }
}

dependencies {

    implementation(libs.core.ktx)
    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.activity.compose)
    implementation(platform(libs.compose.bom))
    implementation(libs.ui)
    implementation(libs.ui.graphics)
    implementation(libs.ui.tooling.preview)
    implementation(libs.material3)
    implementation(project(mapOf("path" to ":domain")))
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(platform(libs.compose.bom))
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
    implementation(libs.navigation.compose)
    implementation(libs.compose.material)
    implementation(project(path = ":feature:home"))
    implementation(project(path = ":feature:search"))
    implementation(project(path = ":feature:favorite"))
    implementation(project(path = ":common"))
    implementation(project(path = ":data"))
    implementation(libs.compose.ui.util)
    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation)
    kapt(libs.hilt.android.compiler)
    implementation(libs.hilt.navigation.compose)
    implementation(libs.retrofit)
    implementation(libs.retrofit.gson)
    implementation(libs.google.gson)
    implementation(libs.animated.navigation.bar)
    implementation(libs.room.database.runtime)
    kapt(libs.room.database.compiler)
    implementation(libs.room.database.ktx)

}