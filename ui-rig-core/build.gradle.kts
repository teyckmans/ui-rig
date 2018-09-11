import com.jfrog.bintray.gradle.BintrayExtension
import com.jfrog.bintray.gradle.BintrayUploadTask
import com.jfrog.bintray.gradle.BintrayPlugin
import org.jetbrains.kotlin.gradle.tasks.Kotlin2JsCompile

buildscript {
    val kotlinVersion = "1.2.21"

    repositories {
        jcenter()
        maven(url = "https://dl.bintray.com/kotlin/kotlin-eap")
    }
    dependencies {
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}

plugins {
    java
//    id("com.jfrog.bintray") version "1.8.0"
    maven
    `maven-publish`
}
plugins.apply(BintrayPlugin::class.java)

apply {
    plugin("kotlin2js")
}

val releaseVersion by project

group = "eu.rigeldev.uirig"
version = releaseVersion as String

repositories {
    jcenter()
}

dependencies {
    val kotlinVersion = "1.2.21"

    compile ("org.jetbrains.kotlin:kotlin-stdlib-js:$kotlinVersion")
}

tasks {
    "compileKotlin2Js"(Kotlin2JsCompile::class) {
        kotlinOptions {
            metaInfo = true
            sourceMap = true
            moduleKind = "commonjs"
        }
    }
    "jar"(Jar::class) {
        manifest {
            attributes["Implementation-Version"] = releaseVersion
            attributes["Specification-Title"] = project.name
            attributes["Kotlin-JS-Module-Name"] = project.name
        }
    }
}



publishing {
    (publications) {
        "UiRigCorePublication"(MavenPublication::class) {
            from(components["java"])
            groupId = project.group as String
            artifactId = project.name as String
            version = project.version as String
        }
    }
}

val bintrayUser by project
val bintrayApiKey by project

configure<BintrayExtension> {
    user = bintrayUser as String
    key = bintrayApiKey as String
    publications.add("UiRigCorePublication")
    publish = true

    pkg(closureOf<BintrayExtension.PackageConfig>{
        repo = "rigeldev-oss-maven"
        name = "ui-rig-core"

        licenses + "MIT"
        vcsUrl = "https://bitbucket.org/rigeldev/rigeldev-ui.git"
    })
}
