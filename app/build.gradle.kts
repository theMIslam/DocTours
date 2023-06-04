plugins {
    id(Plugins.AGP.application)
    kotlin(Plugins.Kotlin.android)
    kotlin(Plugins.Kotlin.kapt)

    // Navigation Safe Args
    id(Plugins.Navigation.safeArgs)

    // Hilt
    id(Plugins.Hilt.android)
}

android {
    namespace = Namespaces.app

    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        applicationId = "com.example.doctour"
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
        versionCode = 1
        versionName = "1.0"
    }

    buildTypes {
        getByName(AndroidConfig.release) {
            isMinifyEnabled = true
            isShrinkResources = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }

        getByName(AndroidConfig.debug) {
            applicationIdSuffix = ".${AndroidConfig.debug}"
            isDebuggable = true
        }
    }
    compileOptions {
        sourceCompatibility = Options.compileOptions
        targetCompatibility = Options.compileOptions
    }
    kotlinOptions {
        jvmTarget = Options.kotlinOptions
    }
    buildFeatures {
        buildConfig = true
        viewBinding = true
    }
//<<<<<<< HEAD
//
//    dependencies {
//
//        // Module
//        implementation(project(":data"))
//        implementation(project(":domain"))
//
//        // Android
//        implementation(Deps.UI.androidCore)
//        implementation(Deps.UI.appcompat)
//        implementation(Deps.UI.material)
//
//        // Container layout
//        implementation(Deps.UI.constraint)
//        implementation(Deps.UI.appcompat)
//        implementation(Deps.UI.material)
//        implementation(Deps.UI.constraint)
//
//        // Test
//        testImplementation(Deps.UI.junit)
//        androidTestImplementation(Deps.UI.extJunit)
//        androidTestImplementation(Deps.UI.espresso)
//
//        // Fragment
//        implementation(Deps.UI.fragment)
//
//        // Hilt
//        implementation(Deps.DaggerHilt.hilt)
//        kapt(Deps.DaggerHilt.compiler)
//
//        // Retrofit2 (data)
//        implementation(Deps.Retrofit.retrofit)
//        implementation(Deps.Retrofit.retrofitConverterGson)
//
//        // Glide (data)
//        implementation(Deps.Glide.glide)
//
//        // Nav component
//        implementation(Deps.NavComponent.fragment)
//        implementation(Deps.NavComponent.ui)
//
//        // View Binding property delegate (reflection-free flavor) (data)
//        implementation(Deps.ViewBindingDelegate.viewBindingDelegate)
//
//        // Lifecycle
//        implementation(Deps.Lifecycle.lifecycle)
//        implementation(Deps.Lifecycle.lifecycleViewModel)
//
//        // Dublicate
//        implementation(Deps.Dublicate.dublicate)
//
//        // DotsIndicator
//        implementation(Deps.DotsIndicator.dotsIndicator)
//
//        // CircleIndicator
//        implementation(Deps.CircleIndicator.circleIndicator)
//
//        // CircleImageView
//        implementation(Deps.CircleImageView.circleImageView)
//
//        // Lottie Animation
//        implementation(Deps.LottieAnimation.lottieanimation)
//
//        // ViewPager2
//        implementation(Deps.ViewPager2.viewpager2)
//
//        // Paging3
//        implementation(Deps.Paging3.paging3)
//        implementation(Deps.Paging3.paging3Runtime)
//
//    }
//=======
//>>>>>>> 9421fba5a8f4aa3a39f17ddd281911f14bfa8dcd
//}

dependencies {

    implementation(project(":data"))
    implementation(project(":domain"))

    // Kotlin
    implementation(Libraries.Coroutines.android)

    // UI Components
    implementation(Libraries.UIComponents.material)
    implementation(Libraries.UIComponents.constraintLayout)
    implementation(Libraries.UIComponents.vbpd)

    // Core
    implementation(Libraries.Core.core)
    implementation(Libraries.Core.splashscreen)

    // Activity
    implementation(Libraries.Activity.activity)

    // Fragment
    implementation(Libraries.Fragment.fragment)

    // Lifecycle
    implementation(Libraries.Lifecycle.viewModel)
    implementation(Libraries.Lifecycle.runtime)

    // Navigation
    implementation(Libraries.Navigation.fragment)
    implementation(Libraries.Navigation.ui)

    // Hilt
    implementation(Libraries.Hilt.android)
    kapt(Libraries.Hilt.compiler)

    // Glide
    implementation(Libraries.Glide.glide)

    // Dublicate
    implementation(Libraries.Dublicate.dublicate)

    // DotsIndicator
    implementation(Libraries.DotsIndicator.dotsIndicator)

    // CircleIndicator
    implementation(Libraries.CircleIndicator.circleIndicator)

    // CircleImageView
    implementation(Libraries.CircleImageView.circleImageView)

    // Lottie Animation
    implementation(Libraries.LottieAnimation.lottieanimation)

    // ViewPager2
    implementation(Libraries.ViewPager2.viewpager2)

}
}