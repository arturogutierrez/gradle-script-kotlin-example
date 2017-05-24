import org.gradle.script.lang.kotlin.repositories

buildscript {

    repositories {
        jcenter()
    }

    dependencies {
        classpath("com.android.tools.build:gradle:2.3.2")
    }
}

allprojects {
    repositories {
        jcenter()
        maven { url = uri("https://maven.google.com") }
    }
}