import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

buildscript {
    val springBootVersion by extra ("2.0.0.M7")

    repositories {
        maven(url ="https://repo.spring.io/milestone")
    }

    dependencies {
        classpath("org.springframework.boot:spring-boot-gradle-plugin:$springBootVersion")
    }
}

val releaseVersion by project

group = "eu.rigeldev.uirig"
version = releaseVersion as String

plugins {
    val kotlinVersion = "1.2.21"

    id("org.jetbrains.kotlin.jvm") version kotlinVersion
    id("org.jetbrains.kotlin.plugin.spring") version kotlinVersion

    id("io.spring.dependency-management") version "1.0.3.RELEASE"
}

apply {
    plugin("org.springframework.boot")
}

repositories {
    mavenCentral()
    maven(url ="http://repo.spring.io/milestone")
}

dependencies {
    compile("org.jetbrains.kotlin:kotlin-stdlib")
    compile("org.springframework.boot:spring-boot-starter-web")

    runtime("com.fasterxml.jackson.datatype:jackson-datatype-jdk8")
    runtime("com.fasterxml.jackson.datatype:jackson-datatype-jsr310")
    runtime("com.fasterxml.jackson.module:jackson-module-kotlin")

    testCompile("org.springframework.boot:spring-boot-starter-test")
}

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions {
            jvmTarget = "1.8"
        }
    }
}