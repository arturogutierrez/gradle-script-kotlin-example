import org.gradle.script.lang.kotlin.applyFrom
import org.gradle.script.lang.kotlin.extra
import org.gradle.script.lang.kotlin.repositories

buildscript {

    repositories {
        jcenter()
    }

    dependencies {
        applyFrom("dependencies.gradle.kts")

        val projectConfiguration: ProjectConfiguration by extra

        classpath(projectConfiguration.buildPlugins.androidGradle)
        classpath(projectConfiguration.buildPlugins.kotlinGradlePlugin)
    }
}

allprojects {
    repositories {
        jcenter()
        maven { url = uri("https://maven.google.com") }
    }
}