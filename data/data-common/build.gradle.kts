plugins {
    id("ggne.android.data")
}

android {
    namespace = "com.ggne.data_common"
}

dependencies {
    testImplementation(libs.bundles.test)
}