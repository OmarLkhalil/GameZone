@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    alias(libs.plugins.androidlibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.hilt)
    alias(libs.plugins.kotlinKapt)
}

android {
    compileSdk = 33
    namespace = "com.mobilebreakero.favorite"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    configurations {
        named("implementation") {
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
    debugImplementation(libs.ui.tooling)
    debugImplementation(libs.ui.test.manifest)
    implementation(project(mapOf("path" to ":common")))
    implementation(project(mapOf("path" to ":data")))
    implementation(libs.lifecycle.viewmodel)
    implementation(libs.coil.compose)
    implementation(libs.compose.ui.util)
    implementation(libs.navigation.compose)
    implementation(libs.compose.material)
    implementation(libs.hilt.android)
    implementation(libs.hilt.navigation.compose)
    kapt(libs.hilt.android.compiler)
    implementation(libs.room.database.runtime)
    kapt(libs.room.database.compiler)
    implementation(libs.room.database.ktx)

}