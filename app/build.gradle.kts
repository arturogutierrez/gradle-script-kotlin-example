
import org.gradle.api.artifacts.ExternalModuleDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.script.lang.kotlin.*

apply {
    plugin("com.android.application")
    plugin("kotlin-android")
    plugin("kotlin-kapt")
}

applyFrom("../dependencies.gradle.kts")

val projectConfiguration: ProjectConfiguration by extra

android {
    compileSdkVersion(projectConfiguration.android.compileSdkVersion)
    buildToolsVersion(projectConfiguration.android.buildToolsVersion)

    defaultConfig {
        minSdkVersion(projectConfiguration.android.minSdkVersion)
        targetSdkVersion(projectConfiguration.android.targetSdkVersion)

        applicationId = "com.tuenti.masala"
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles("proguard-rules.pro")
        }
    }

    sourceSets {
        getByName("main") {
            java.srcDirs("src/main/kotlin")
        }
    }

}

dependencies {

    compile(projectConfiguration.libs.kotlinStdLib)
    compile(projectConfiguration.libs.appCompat)
    compile(projectConfiguration.libs.constraintLayout)
    compile(projectConfiguration.libs.dagger)
    kapt(projectConfiguration.libs.daggerCompiler)

    testCompile(projectConfiguration.testLibs.junit)
    testCompile(projectConfiguration.testLibs.mockito)

    androidTestCompile(projectConfiguration.testLibs.espresso) {
        exclude("com.android.support", "support-annotations")
    }
}

inline fun DependencyHandler.androidTestCompile(
        dependencyNotation: String,
        dependencyConfiguration: ExternalModuleDependency.() -> Unit): ExternalModuleDependency =
        add("androidTestCompile", dependencyNotation, dependencyConfiguration)