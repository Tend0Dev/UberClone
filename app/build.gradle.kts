plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.google.gms.google.services)
}

android {
    namespace = "com.valo.uberclone"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.valo.uberclone"
        minSdk = 23
        targetSdk = 34
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {

    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.database)
    implementation(libs.firebase.auth.v1910)
    implementation(libs.firebase.auth)
    implementation(libs.spots.dialog)
    implementation(libs.play.services.maps.v1801)
    implementation (libs.play.services.location.v2101)
    implementation(libs.constraintlayout.v212)
    testImplementation(libs.junit)
    implementation ("com.firebase:geofire-android:3.1.0")
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
    implementation("com.github.niqo01.rxplayservices:rx-play-services-location:0.4.0")

}