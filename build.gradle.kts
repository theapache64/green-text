plugins {
    kotlin("multiplatform") version "1.6.10"
}

group = "com.github.theapache64"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    google()

    maven { url = uri("https://maven.pkg.jetbrains.space/public/p/compose/dev") }
}
buildscript {
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.6.10")
    }
}

kotlin {
    jvm {
        compilations.all {
            kotlinOptions.jvmTarget = "1.8"
        }
        withJava()
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }


    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation("androidx.compose.ui:ui:1.1.0-rc01")
                implementation("androidx.compose.runtime:runtime:1.1.0-rc01")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val jvmMain by getting
        val jvmTest by getting
    }
}
