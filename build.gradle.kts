import org.gradle.api.JavaVersion.VERSION_1_8
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    idea
    kotlin("jvm") version "1.3.60"
    id("org.jetbrains.intellij") version "0.4.13"
}

apply {
    plugin("idea")
    plugin("kotlin")
    plugin("org.jetbrains.intellij")
}

repositories {
    mavenCentral()
}

intellij {
    version = "IU-201.3803-EAP-CANDIDATE-SNAPSHOT"
    pluginName = "wrong-path-resolver"
    instrumentCode = false
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        jvmTarget = "1.8"
        languageVersion = "1.3"
        apiVersion = "1.3"
        freeCompilerArgs = listOf("-Xjvm-default=enable")
    }
}

configure<JavaPluginConvention> {
    sourceCompatibility = VERSION_1_8
    targetCompatibility = VERSION_1_8
}
