pluginManagement {
    repositories {
        gradlePluginPortal()
        maven("https://jitpack.io")
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}
rootProject.name = "DocTour"
include(
    ":app",
    ":data",
    ":domain",
)
