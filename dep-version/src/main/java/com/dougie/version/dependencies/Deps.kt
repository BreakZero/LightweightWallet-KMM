package com.dougie.version.dependencies

object Versions {
    val kotlin = "1.4.20"
    val android_gradle_plugin = "4.0.1"

    val coroutines = "1.3.9-native-mt-2"
    val koin = "3.0.0-alpha-4"
    val kermit = "0.1.8"
    val ktlint_gradle_plugin = "9.4.1"
    val cocoapodsext = "0.11"
    val ktor = "1.4.2"
    val junit = "4.13"
    val material = "1.2.1"
    val sqlDelight = "1.4.4"
    val serialization = "1.0.0"

    object AndroidX {
        val appcompat = "1.2.0"
        val constraintlayout = "2.0.4"
        val core = "1.3.2"
        val lifecycle = "2.2.0"
        val recyclerview = "1.1.0"
        val test = "1.3.0"
        val test_ext = "1.1.2"
    }
}

object Deps {
    val android_gradle_plugin = "com.android.tools.build:gradle:${Versions.android_gradle_plugin}"
    val junit = "junit:junit:${Versions.junit}"
    val cocoapodsext = "co.touchlab:kotlinnativecocoapods:${Versions.cocoapodsext}"
    val material = "com.google.android.material:material:${Versions.material}"
    val koinCore = "org.koin:koin-core:${Versions.koin}"
    val koinTest = "org.koin:koin-test:${Versions.koin}"
    val kermit = "co.touchlab:kermit:${Versions.kermit}"

    object AndroidX {
        val appcompat = "androidx.appcompat:appcompat:${Versions.AndroidX.appcompat}"
        val core_ktx = "androidx.core:core-ktx:${Versions.AndroidX.core}"
        val constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.AndroidX.constraintlayout}"
        val recyclerView = "androidx.recyclerview:recyclerview:${Versions.AndroidX.recyclerview}"
        val lifecycle_viewmodel = "androidx.lifecycle:lifecycle-viewmodel:${Versions.AndroidX.lifecycle}"
        val lifecycle_viewmodel_extensions = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.AndroidX.lifecycle}"
        val lifecycle_livedata = "androidx.lifecycle:lifecycle-livedata:${Versions.AndroidX.lifecycle}"
        val lifecycle_extension = "androidx.lifecycle:lifecycle-extensions:${Versions.AndroidX.lifecycle}"
    }

    object AndroidXTest {
        val core = "androidx.test:core:${Versions.AndroidX.test}"
        val junit = "androidx.test.ext:junit:${Versions.AndroidX.test_ext}"
        val runner = "androidx.test:runner:${Versions.AndroidX.test}"
        val rules = "androidx.test:rules:${Versions.AndroidX.test}"
    }

    object KotlinTest {
        val common = "org.jetbrains.kotlin:kotlin-test-common:${Versions.kotlin}"
        val annotations = "org.jetbrains.kotlin:kotlin-test-annotations-common:${Versions.kotlin}"
        val jvm = "org.jetbrains.kotlin:kotlin-test:${Versions.kotlin}"
        val junit = "org.jetbrains.kotlin:kotlin-test-junit:${Versions.kotlin}"
    }

    object Coroutines {
        val common = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
        val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        val test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.coroutines}"
    }

    object SqlDelight {
        val gradle = "com.squareup.sqldelight:gradle-plugin:${Versions.sqlDelight}"
        val runtime = "com.squareup.sqldelight:runtime:${Versions.sqlDelight}"
        val runtimeJdk = "com.squareup.sqldelight:runtime-jvm:${Versions.sqlDelight}"
        val driverIos = "com.squareup.sqldelight:native-driver:${Versions.sqlDelight}"
        val driverAndroid = "com.squareup.sqldelight:android-driver:${Versions.sqlDelight}"
    }

    object Ktor {
        val commonCore = "io.ktor:ktor-client-core:${Versions.ktor}"
        val commonJson = "io.ktor:ktor-client-json:${Versions.ktor}"
        val commonLogging = "io.ktor:ktor-client-logging:${Versions.ktor}"
        val androidCore = "io.ktor:ktor-client-android:${Versions.ktor}"
        val androidokhttp = "io.ktor:ktor-client-okhttp:${Versions.ktor}"
        val ios = "io.ktor:ktor-client-ios:${Versions.ktor}"
        val commonSerialization = "io.ktor:ktor-client-serialization:${Versions.ktor}"
    }
}