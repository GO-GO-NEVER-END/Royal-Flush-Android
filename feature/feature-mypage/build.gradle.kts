plugins {
    id("ggne.android.feature")
    id("org.jetbrains.kotlin.android")
}

android {
    namespace = "com.ggne.feature_mypage"
}

dependencies {
    testImplementation(libs.bundles.test)
    androidTestImplementation(libs.bundles.test.android)
}