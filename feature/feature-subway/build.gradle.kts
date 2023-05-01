plugins {
    id("ggne.android.feature")
    alias(libs.plugins.kotlin.android)
}

android {
    namespace = "com.ggne.feature_subway"
}
dependencies {
    testImplementation(libs.bundles.test)
    androidTestImplementation(libs.bundles.test.android)
}
