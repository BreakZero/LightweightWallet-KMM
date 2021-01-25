import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget
import com.dougie.version.dependencies.Deps

plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("kotlinx-serialization")
    id("com.squareup.sqldelight")
    id("kotlin-android-extensions")
    id("com.dougie.version")
    kotlin("native.cocoapods")
}
group = "com.dougie.wallet"
version = "1.0-SNAPSHOT"

repositories {
    gradlePluginPortal()
    google()
    jcenter()
    mavenCentral()
}

kotlin {
    targets.withGroovyBuilder {
        val onPhone = System.getenv("SDK_NAME")?.startsWith("iphoneos") ?: false
        if (onPhone) {
            "fromPreset"(presets["iosArm64"], "ios")
        } else {
            "fromPreset"(presets["iosX64"], "ios")
        }
        "fromPreset"(presets["android"], "android")
    }
//    android()
//    ios()

    version = "1.0.0"
    cocoapods {
        podfile = project.file("../iosApp/Podfile")

        // Configure fields required by CocoaPods.
        summary = "Some description for a Kotlin/Native module"
        homepage = "Link to a Kotlin/Native module homepage"

        frameworkName = "shared"
        ios.deploymentTarget = "13.0"
        /*pod("TrustWalletCore") {
            source = git("https://github.com/trustwallet/wallet-core.git") {
                tag = "2.5.4"
            }
        }*/
    }

    sourceSets {
        this.forEach {
            println("======= ${it.name}")
        }
        val commonMain by getting {
            dependencies {
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.0.1")
                implementation(Deps.Ktor.commonCore)
                implementation(Deps.Ktor.commonJson)
                implementation(Deps.Ktor.commonLogging)
                implementation(Deps.Coroutines.common)
                implementation(Deps.koinCore)
                implementation(Deps.Ktor.commonSerialization)
                implementation(Deps.SqlDelight.runtime)
                api(Deps.kermit)
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test-common"))
                implementation(kotlin("test-annotations-common"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation(Deps.SqlDelight.driverAndroid)
                implementation(Deps.Ktor.androidCore)
            }
        }
        val androidTest by getting {
            dependencies {
                implementation(kotlin("test-junit"))
                implementation("junit:junit:4.12")
            }
        }
        val iosMain by getting {
            dependencies {
                implementation(Deps.Ktor.ios)
                implementation(Deps.SqlDelight.driverIos)
            }
        }
        val iosTest by getting
    }
}
android {
    compileSdkVersion(29)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(24)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0.0"
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}

sqldelight {
    database("WalletDatabase") {
        packageName = "com.dougie.wallet.db"
    }
}

val packForXcode by tasks.creating(Sync::class) {
    group = "build"
    val mode = System.getenv("CONFIGURATION") ?: "DEBUG"
    val framework = kotlin.targets.getByName<KotlinNativeTarget>("ios").binaries.getFramework(mode)
    inputs.property("mode", mode)
    dependsOn(framework.linkTask)
    val targetDir = File(buildDir, "xcode-frameworks")
    from({ framework.outputDirectory })
    into(targetDir)
}
tasks.getByName("build").dependsOn(packForXcode)