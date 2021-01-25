buildscript {
    repositories {
        gradlePluginPortal()
        jcenter()
        google()
        mavenCentral()
    }
    dependencies {
        classpath(kotlin("gradle-plugin", "1.4.20"))
        classpath("com.android.tools.build:gradle:4.0.1")
        classpath(kotlin("serialization", version = "1.4.20"))
        classpath("com.squareup.sqldelight:gradle-plugin:1.4.4")
    }
}
group = "com.dougie.wallet"
version = "1.0-SNAPSHOT"

allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter()
        maven(url = "https://kotlin.bintray.com/kotlinx")
        maven(url = "https://dl.bintray.com/ekito/koin")
        maven(url = "https://oss.sonatype.org/content/repositories/snapshots/")
    }
}
