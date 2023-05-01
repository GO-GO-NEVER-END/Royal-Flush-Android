@file:Suppress("UnstableApiUsage")
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("ggne.android.application")
    id("ggne.android.hilt")
}

android {
    namespace = "com.ggne.royalflush"

    defaultConfig {
        applicationId = "com.ggne.royalflush"
    }

    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.fragment.ktx)
    implementation(project(":feature:feature-home"))
    implementation(project(":feature:feature-subway"))
    implementation(project(":feature:feature-teatime"))
    implementation(project(":feature:feature-mypage"))
}