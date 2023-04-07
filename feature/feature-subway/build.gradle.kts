plugins {
    id("ggne.android.feature")
}

android {
    namespace = "com.ggne.feature_subway"
}
dependencies {
    testImplementation(libs.bundles.test)
    androidTestImplementation(libs.bundles.test.android)
}
