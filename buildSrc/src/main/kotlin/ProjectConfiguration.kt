class ProjectConfiguration(
    val buildPlugins: BuildPlugins,
    val android: Android,
    val libs: Libs,
    val testLibs : TestLibs
)

class Android(
    val buildToolsVersion: String,
    val minSdkVersion: Int,
    val targetSdkVersion: Int,
    val compileSdkVersion: Int
)

class BuildPlugins(
    val androidGradle: String,
    val kotlinGradlePlugin: String
)

class Libs(
    val kotlinStdLib: String,
    val appCompat: String,
    val constraintLayout: String,
    val dagger: String,
    val daggerCompiler: String
)

class TestLibs(
    val junit: String,
    val mockito: String,
    val espresso: String
)
