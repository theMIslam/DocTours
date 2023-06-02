plugins {
    id(Plugins.Java.library)
    id(Plugins.Kotlin.jvm)
}

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {

    // Coroutines
    implementation(Deps.Coroutines.core)

    // Javax
    implementation(Deps.JavaX.inject)
}