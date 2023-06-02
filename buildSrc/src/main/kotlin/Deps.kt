object Versions {
    const val AGP = "7.3.0"
    const val kotlin = "1.7.0"
    const val coroutines = "1.6.4"
    const val appCompat = "1.6.1"
    const val androidCore = "1.9.0"
    const val hilt = "2.44.2"
    const val room = "2.5.1"
    const val material = "1.9.0"
    const val constraint = "2.1.4"
    const val extJUnit = "1.1.5"
    const val jUnit = "4.13.2"
    const val espresso = "3.5.1"
    const val navigation = "2.5.2"
    const val fragment = "1.5.7"
    const val viewBindingDelegate = "1.5.9"
    const val lifecycle = "2.6.1"
    const val glide = "4.15.0"
    const val lottieanimation = "5.2.0"
    const val retrofit = "2.9.0"
    const val paging3 = "3.1.1"
    const val dublicate = "1.8.0"
    const val dotsindicator = "4.3"
    const val circleindicator = "2.1.6"
    const val circleimageview = "3.1.0"
    const val viewpager2 = "1.0.0"
}

object Deps {
    object UI {
        const val androidCore = "androidx.core:core-ktx:${Versions.androidCore}"
        const val appcompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val material = "com.google.android.material:material:${Versions.material}"
        const val constraint = "androidx.constraintlayout:constraintlayout:${Versions.constraint}"
        const val junit = "junit:junit:${Versions.jUnit}"
        const val extJunit = "androidx.test.ext:junit:${Versions.extJUnit}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
        const val fragment = "androidx.fragment:fragment-ktx:${Versions.fragment}"
    }

    object Room {
        const val room = "androidx.room:room-ktx:${Versions.room}"
        const val roomRuntime = "androidx.room:room-runtime:${Versions.room}"
        const val compiler = "androidx.room:room-compiler:${Versions.room}"
    }

    object Paging3 {
        const val paging3 = "androidx.paging:paging-common-ktx:${Versions.paging3}"
        const val paging3Runtime = "androidx.paging:paging-runtime:${Versions.paging3}"
    }

    object Retrofit {
        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val retrofitConverterGson = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    }

    object DaggerHilt {
        const val hilt = "com.google.dagger:hilt-android:${Versions.hilt}"
        const val compiler = "com.google.dagger:hilt-compiler:${Versions.hilt}"
    }

    object Coroutines {
        const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutines}"
        const val core = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.coroutines}"
    }

    object Glide {
        const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
    }

    object NavComponent {
        const val fragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val ui = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
    }

    object Lifecycle {
        const val lifecycle = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle}"
        const val lifecycleViewModel = "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle}"
    }

    object Dublicate {
        const val dublicate = "org.jetbrains.kotlin:kotlin-bom:${Versions.dublicate}"
    }

    object DotsIndicator {
        const val dotsIndicator = "com.tbuonomo:dotsindicator:${Versions.dotsindicator}"
    }

    object CircleIndicator {
        const val circleIndicator = "me.relex:circleindicator:${Versions.circleindicator}"
    }

    object CircleImageView {
        const val circleImageView = "de.hdodenhof:circleimageview:${Versions.circleimageview}"
    }

    object LottieAnimation {
        const val lottieanimation = "com.airbnb.android:lottie:${Versions.lottieanimation}"
    }

    object ViewPager2 {
        const val viewpager2 = "androidx.viewpager2:viewpager2:${Versions.viewpager2}"
    }

    object ViewBindingDelegate {
        const val viewBindingDelegate =
            "com.github.kirich1409:viewbindingpropertydelegate-noreflection:${Versions.viewBindingDelegate}"
    }

    object JavaX {
        const val inject = "javax.inject:javax.inject:1"
    }
}

object Plugins {
    object AGP {
        const val application = "com.android.application"
        const val library = "com.android.library"
    }

    object Kotlin {
        const val android = "org.jetbrains.kotlin.android"
        const val kapt = "kotlin-kapt"
        const val jvm = "org.jetbrains.kotlin.jvm"
        const val hilt = "com.google.dagger.hilt.android"
    }

    object DaggerHilt {
        const val hilt = "com.google.dagger.hilt.android"
    }

    object Java {
        const val library = "java-library"
    }
}