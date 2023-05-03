@Suppress("DSL_SCOPE_VIOLATION")

plugins {
    id("ggne.android.feature")
}

android {
    namespace = "com.ggne.feature_subway"
}
dependencies {
    implementation("androidx.navigation:navigation-fragment-ktx:2.5.3")
    implementation("androidx.navigation:navigation-ui-ktx:2.5.3")
    testImplementation(libs.bundles.test)
    androidTestImplementation(libs.bundles.test.android)
}
