plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.solera.pokemon"
    compileSdk = 36

    defaultConfig {
        applicationId = "com.solera.pokemon"
        minSdk = 24
        targetSdk = 36
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    buildFeatures {

        viewBinding = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)

    //implementation("com.squareup.retrofit2:retrofit:3.0.0")
    implementation(libs.retrofit)
    //implementation("com.squareup.retrofit2:converter-gson:3.0.0")
    implementation(libs.converter.gson)
    //implementation("com.github.bumptech.glide:glide:4.16.0")
    implementation(libs.glide)
    //implementation("com.google.android.material:material:1.2.0-alpha02")
    implementation(libs.material.v120alpha02)
}