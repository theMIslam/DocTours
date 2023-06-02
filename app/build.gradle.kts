plugins {
    id(Plugins.AGP.application)
    id(Plugins.Kotlin.android)
    id(Plugins.Kotlin.kapt)
    id(Plugins.DaggerHilt.hilt)
}

android {
    namespace = "com.example.doctour"
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        applicationId = "com.example.doctour"
        minSdk = AndroidConfig.minSdk
        targetSdk = AndroidConfig.targetSdk
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName

        testInstrumentationRunner = AndroidConfig.androidTestInstrumentation
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        viewBinding = true
    }

    dependencies {

        // Android
        implementation(Deps.UI.androidCore)
        implementation(Deps.UI.appcompat)
        implementation(Deps.UI.material)

        // Container layout
        implementation(Deps.UI.constraint)
        implementation(Deps.UI.appcompat)
        implementation(Deps.UI.material)
        implementation(Deps.UI.constraint)

        // Test
        testImplementation(Deps.UI.junit)
        androidTestImplementation(Deps.UI.extJunit)
        androidTestImplementation(Deps.UI.espresso)

        // Fragment
        implementation(Deps.UI.fragment)

        // Room
        implementation(Deps.Room.room)
        implementation(Deps.Room.roomRuntime)
        kapt(Deps.Room.compiler)

        // Hilt
        implementation(Deps.DaggerHilt.hilt)
        kapt(Deps.DaggerHilt.compiler)

        // Paging3 (data)
        implementation(Deps.Paging3.paging3)
        implementation(Deps.Paging3.paging3Runtime)

        // Retrofit2 (data)
        implementation(Deps.Retrofit.retrofit)
        implementation(Deps.Retrofit.retrofitConverterGson)

        // Glide (data)
        implementation(Deps.Glide.glide)
        implementation(Deps.Glide.glideCompiler)

        // Nav component
        implementation(Deps.NavComponent.fragment)
        implementation(Deps.NavComponent.ui)

        // View Binding property delegate (reflection-free flavor) (data)
        implementation(Deps.ViewBindingDelegate.viewBindingDelegate)

        // Lifecycle
        implementation(Deps.Lifecycle.lifecycle)
        implementation(Deps.Lifecycle.lifecycleViewModel)

        // Coroutines
        implementation(Deps.Coroutines.android)

        // Dublicate
        implementation(Deps.Dublicate.dublicate)

        // DotsIndicator
        implementation(Deps.DotsIndicator.dotsIndicator)

        // CircleIndicator
        implementation(Deps.CircleIndicator.circleIndicator)

        // CircleImageView
        implementation(Deps.CircleImageView.circleImageView)

        // Lottie Animation
        implementation(Deps.LottieAnimation.lottieanimation)

        // ViewPager2
        implementation(Deps.ViewPager2.viewpager2)
    }
}
dependencies {
    implementation(project(mapOf("path" to ":data")))
}
