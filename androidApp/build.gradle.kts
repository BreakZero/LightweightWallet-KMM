import com.dougie.version.dependencies.Deps
plugins {
    id("com.android.application")
    kotlin("android")
    id("kotlinx-serialization")
    id("kotlin-parcelize")
    id("com.dougie.version")
}
group = "com.dougie.wallet"
version = "1.0-SNAPSHOT"

repositories {
    gradlePluginPortal()
    google()
    jcenter()
    mavenCentral()
}
dependencies {
    implementation(project(":shared"))
    implementation(Deps.AndroidX.recyclerView)
    implementation(Deps.material)
    implementation(Deps.AndroidX.appcompat)
    implementation(Deps.AndroidX.core_ktx)
    implementation(Deps.Ktor.androidCore)
    implementation(Deps.AndroidX.constraintlayout)
    implementation(Deps.SqlDelight.runtimeJdk)
    implementation(Deps.SqlDelight.driverAndroid)
    implementation(Deps.Coroutines.common)
    implementation(Deps.Coroutines.android)
    implementation(Deps.koinCore)
    implementation(Deps.AndroidX.lifecycle_viewmodel)
    implementation(Deps.AndroidX.lifecycle_viewmodel_extensions)
    implementation(Deps.AndroidX.lifecycle_livedata)
    implementation(Deps.AndroidX.lifecycle_extension)
    testImplementation(Deps.junit)
}
android {
    compileSdkVersion(29)
    defaultConfig {
        applicationId = "com.dougie.wallet.androidApp"
        minSdkVersion(24)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}