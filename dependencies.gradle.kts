import org.gradle.script.lang.kotlin.extra
import org.gradle.script.lang.kotlin.getValue
import org.gradle.script.lang.kotlin.setValue

var projectConfiguration: ProjectConfiguration by extra

val buildToolsVersion = "25.0.3"
val compileSdkVersion = 25
val minSdkVersion = 16
val targetSdkVersion = 25

// Common
val kotlinVersion = "1.1.2"

// Build plugins
val androidGradleVersion = "2.3.2"

// Libs
val supportVersion = "25.3.1"
val constraintLayoutVersion = "1.0.2"
val daggerVersion = "2.10"

// Test libs
val junitVersion = "4.12"
val mockitoVersion = "2.7.0"
val espressoVersion = "2.2.2"

projectConfiguration = ProjectConfiguration(
        BuildPlugins(
                "com.android.tools.build:gradle:$androidGradleVersion",
                "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion"
        ),
        Android(
                buildToolsVersion,
                minSdkVersion,
                targetSdkVersion,
                compileSdkVersion
        ),
        Libs(
                "org.jetbrains.kotlin:kotlin-stdlib:$kotlinVersion",
                "com.android.support:appcompat-v7:$supportVersion",
                "com.android.support.constraint:constraint-layout:$constraintLayoutVersion",
                "com.google.dagger:dagger:$daggerVersion",
                "com.google.dagger:dagger-compiler:$daggerVersion"
        ),
        TestLibs(
                "junit:junit:$junitVersion",
                "org.mockito:mockito-core:$mockitoVersion",
                "com.android.support.test.espresso:espresso-core:$espressoVersion"

        )
)