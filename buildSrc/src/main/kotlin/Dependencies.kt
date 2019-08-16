import CommonVersion.daggerV
import CommonVersion.glideV
import CommonVersion.okdownloadV
import CommonVersion.rxandroidV
import CommonVersion.rxbindingV
import CommonVersion.rxjavaV

object CommonVersion {
    const val kotlin = "1.3.31"
    const val kotlinCorutines = "1.1.1"
    const val smackVersion = "4.1.8"
    const val sl4j = "1.7.7"
    const val glideV = "4.9.0"
    const val koin = "1.0.1"
    const val constraint = "1.1.3"

    const val daggerV = "2.22.1"

    const val retrofitV = "2.5.0"
    const val rxjavaV = "2.2.8"
    const val rxandroidV = "2.1.1"
    const val rxbindingV = "2.2.0"
    const val rxjavaAdapterV = "1.0.0"

    const val okdownloadV = "1.0.5"

    const val room = "2.0.0-rc01"
    const val lifecycle = "2.0.0-rc01"
    const val gson = "2.8.5"
    const val appcompat = "1.0.0"
    const val fragment = "1.0.0"
    const val multidex = "2.0.1"
    const val annotation = "1.0.0"

    const val navVersion = "2.1.0-beta2"
}

object BuildPlugins {
    const val android_gradleplugin = "3.5.0-rc03"

    const val androidGradlePlugin = "com.android.tools.build:gradle:$android_gradleplugin"
    const val kotlinGradlePlugin =
        "org.jetbrains.kotlin:kotlin-gradle-plugin:${CommonVersion.kotlin}"
    const val nav_version = "2.1.0-beta02"
    const val navigationSafeArgs="androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version"

    const val androidApplication = "com.android.application"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"

}


object AndroidSdk {
    const val min = 19
    const val compile = 29
    const val target = compile
}

object Libs {
    private const val frescoV = "1.13.0"
    private const val constraintLayoutV = "2.0.0-beta2"
    private const val ktxV = "1.1.0-alpha05"
    private const val recyclerviewV = "1.1.0-beta01"
    private const val appcompatV = "1.1.0-rc01"
    private const val materialDesignV = "1.1.0-alpha08"
    private const val cardviewV = "1.0.0"
    private const val legacysupportV = "1.0.0"
    private const val materialdesignV = "1.1.0-alpha08"
    private const val multidexV = "2.0.1"
    private const val room = "2.2.0-alpha01"
    private const val kapt = "1.8.0"

    const val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${CommonVersion.kotlin}"
    const val kotlinReflect = "org.jetbrains.kotlin:kotlin-reflect:${CommonVersion.kotlin}"
    const val kotlinCorutinesCore =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${CommonVersion.kotlinCorutines}"
    const val kotlinCorutinesAndroid =
        "org.jetbrains.kotlinx:kotlinx-coroutines-android:${CommonVersion.kotlinCorutines}"


    //AndroidX
    const val appCompat = "androidx.appcompat:appcompat:$appcompatV"

    //Lifecycle
    const val lifeCycleLivedataCore = "androidx.lifecycle:lifecycle-livedata-core:2.2.0-alpha02"
    const val lifeCycleELivedataKtx = "androidx.lifecycle:lifecycle-livedata-ktx:2.2.0-alpha02"
    const val lifeCycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:2.2.0-alpha02"
    const val lifeCycleExtension = "androidx.lifecycle:lifecycle-extensions:2.0.0"
    const val lifeCycleViewModelKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:2.2.0-alpha02"

    const val recyclerView = "androidx.recyclerview:recyclerview:$recyclerviewV"
    const val constraintLayout = "androidx.constraintlayout:constraintlayout:$constraintLayoutV"
    const val cardView = "androidx.cardview:cardview:$cardviewV"
    const val legacySupport = "androidx.legacy:legacy-support-v4:$legacysupportV"
    const val multidex = "androidx.multidex:multidex:$multidexV"

    const val nav_dep = "2.1.0-beta02"
    // Kotlin
    const val navigationFragmentKtx = "androidx.navigation:navigation-fragment-ktx:$nav_dep"
    const val navigationUIKtx = "androidx.navigation:navigation-ui-ktx:$nav_dep"


    const val materialDesign = "com.google.android.material:material:$materialDesignV"

    const val ktxCore = "androidx.core:core-ktx:$ktxV"

    const val fbFresco = "com.facebook.fresco:fresco:$frescoV"
    const val fbFrescoWebsupport = "com.facebook.fresco:webpsupport:$frescoV"
    const val fbFrescoAnimatedWebp = "com.facebook.fresco:animated-webp:$frescoV"
    const val fbFrescoAnimatedBase = "com.facebook.fresco:animated-base:$frescoV"


    //DI Dagger
    const val daggerKaptCompiler = "com.google.dagger:dagger-compiler:$daggerV"
    const val daggerKaptProcessor = "com.google.dagger:dagger-android-processor:$daggerV"
    const val dagger = "com.google.dagger:dagger:$daggerV"
    const val daggerAndroid = "com.google.dagger:dagger-android:$daggerV"
    const val daggerAndroidSupport = "com.google.dagger:dagger-android-support:$daggerV"

    const val okdownload = "com.liulishuo.okdownload:okdownload:$okdownloadV"
    const val okdownloadSqlite = "com.liulishuo.okdownload:sqlite:$okdownloadV"
    const val okdownloadOkhttp = "com.liulishuo.okdownload:okhttp:$okdownloadV"

    //Rx
    const val rxjava = "io.reactivex.rxjava2:rxjava:$rxjavaV"
    const val rxandroid = "io.reactivex.rxjava2:rxandroid:$rxandroidV"

    //Rx Binding
    const val rxbinding = "com.jakewharton.rxbinding2:rxbinding:$rxbindingV"
    const val rxbindingSupprt = "com.jakewharton.rxbinding2:rxbinding-support-v4:$rxbindingV"
    const val rxbindingAppcompat = "com.jakewharton.rxbinding2:rxbinding-appcompat-v7:$rxbindingV"

    //Image Library
    const val glide = "com.github.bumptech.glide:glide:$glideV"
    const val glideKaptCompiler = "com.github.bumptech.glide:compiler:$glideV"

    //Billing Client
    const val inAppBillingClient = "com.android.billingclient:billing:2.0.2"

    const val timber = "com.jakewharton.timber:timber:4.7.1"

    //Room
    const val roomRuntime = "androidx.room:room-runtime:$room"
    const val roomCompiler = "androidx.room:room-compiler:$room"
    const val roomCoroutines = "androidx.room:room-ktx:$room"

    const val moshi = "com.squareup.moshi:moshi:1.8.0"
    const val moshiKapt = "com.squareup.moshi:moshi-kotlin-codegen:1.8.0"
    const val moshiKotlin = "com.squareup.moshi:moshi-kotlin:1.8.0"
    const val moshiAdapter = "com.squareup.moshi:moshi-adapters:1.8.0"
}

object FirebaseLibs {
    const val firebaseConfig = "com.google.firebase:firebase-config:18.0.0"
    const val firebaseDB = "com.google.firebase:firebase-database:18.0.0"
    const val firebaseCore = "com.google.firebase:firebase-core:17.0.1"
    const val firebaseMsg = "com.google.firebase:firebase-messaging:19.0.1"
    const val firebasePerf = "com.google.firebase:firebase-perf:18.0.1"

    const val playServiceAuth = "com.google.android.gms:play-services-auth:17.0.0"
    const val playServiceAnalytics = "com.google.android.gms:play-services-analytics:17.0.0"
    const val playServiceAds = "com.google.android.gms:play-services-ads:18.1.0"
    const val playServiceBasement = "com.google.android.gms:play-services-basement:17.0.0"
}

object TestLibs {
    private const val junit4V = "4.12"
    private const val testRunnerV = "1.0.2"
    private const val espressoV = "3.0.2"


    const val junit4 = "junit:junit:$junit4V"
    const val testRunner = "com.android.support.test:runner:$testRunnerV"
    const val espresso = "com.android.support.test.espresso:espresso-core:$espressoV"
}
