import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
    id("com.google.gms.google-services")
}


android {
    namespace = "com.example.habits"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.habits"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
        kotlinCompilerExtensionVersion = "1.4.3"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.7.0")
    implementation("androidx.activity:activity-compose:1.9.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")


    val accompanistVersion = "0.28.0"
    // Pager
    implementation("com.google.accompanist:accompanist-pager:$accompanistVersion")
    implementation("com.google.accompanist:accompanist-pager-indicators:$accompanistVersion")

    //hilt dagger
    implementation("com.google.dagger:hilt-android:2.45")
    implementation("androidx.hilt:hilt-navigation-compose:1.2.0")
    kapt("com.google.dagger:hilt-compiler:2.45")
    kapt("androidx.hilt:hilt-compiler:1.2.0")


    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.7.0")
    implementation("androidx.navigation:navigation-compose:2.7.7")
    implementation("androidx.activity:activity-ktx:1.9.0")


    //Get day of week api 25 or lower
    coreLibraryDesugaring("com.android.tools:desugar_jdk_libs:2.0.2")

    val time_picker = "1.1.0"
    implementation("com.maxkeppeler.sheets-compose-dialogs:core:$time_picker")
    implementation("com.maxkeppeler.sheets-compose-dialogs:clock:$time_picker")

    implementation(platform("com.google.firebase:firebase-bom:33.1.0"))
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-auth-ktx")

    //room
    val room_version = "2.6.1"

    implementation("androidx.room:room-runtime:$room_version")
    kapt("androidx.room:room-compiler:$room_version")
    implementation("androidx.room:room-ktx:$room_version")

    implementation("com.squareup.moshi:moshi:1.15.1")

    // retrofit
    val retrofit_version = "2.9.0"
    implementation("com.squareup.retrofit2:retrofit:$retrofit_version")
    implementation("com.squareup.retrofit2:converter-moshi:$retrofit_version")
    implementation("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.2")

    val workmanager_version = "2.8.0"

    implementation("androidx.work:work-runtime-ktx:$workmanager_version")
    implementation("androidx.hilt:hilt-work:1.2.0")

    

}

