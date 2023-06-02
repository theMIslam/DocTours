buildscript {
    dependencies {
        classpath("com.google.gms:google-services:4.3.10")
    }
    repositories {
        google()
    }
}
plugins {
    id(Plugins.AGP.application) version Versions.AGP apply false
    id(Plugins.AGP.library) version Versions.AGP apply false
    id(Plugins.Kotlin.android) version Versions.kotlin apply false
    id(Plugins.DaggerHilt.hilt) version Versions.hilt apply false
    id(Plugins.Kotlin.jvm) version Versions.kotlin apply false
}
