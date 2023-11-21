plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.devtools.ksp")
    id("com.google.dagger.hilt.android")
    id("org.jetbrains.kotlin.kapt")
}

android {
    namespace = "com.example.creditcardexpenses"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.creditcardexpenses"
        minSdk = 26
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

    val version = "1.5.2"

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.1")
    implementation("androidx.activity:activity-compose:1.7.2")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui-android:1.5.2")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    
    //Para crear el gràfico de navegaciòn
    implementation("androidx.navigation:navigation-compose:2.7.3")

    //Hilt Dagger
    implementation("androidx.hilt:hilt-navigation-compose:1.0.0")

    implementation("com.google.dagger:hilt-android:2.44.2")
     kapt("com.google.dagger:hilt-android-compiler:2.44.2")

    //Room
    implementation("androidx.room:room-runtime:2.5.2")
    annotationProcessor("androidx.room:room-compiler:2.5.2")
     ksp("androidx.room:room-compiler:2.5.2")

    implementation("androidx.room:room-ktx:2.5.2")


    //GSON convertir objetos que llegan en JSON hacia objetos  y
    //Retrofit  Para hacer peticiones al server
    implementation("com.squareup.retrofit2:retrofit:2.9.0:")
    implementation("com.google.code.gson:gson:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0:")

    implementation("com.squareup.moshi:moshi-kotlin:1.14.0")

    implementation("androidx.datastore:datastore-preferences:1.0.0")

    //splash
    implementation("androidx.core:core-splashscreen:1.1.0-alpha02")

    //File transformation
    implementation("commons-io:commons-io:2.7")

    //
    implementation("androidx.compose.material:material:$version")
    implementation("androidx.compose.material3:material3:1.1.2")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")
}