@Suppress("DSL_SCOPE_VIOLATION")

plugins {
    id("ggne.android.feature")
}

android {
    namespace = "com.ggne.feature_home"
}

dependencies {
    testImplementation(libs.bundles.test)
    androidTestImplementation(libs.bundles.test.android)
}