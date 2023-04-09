package com.ggne.build_logic

import org.gradle.api.JavaVersion

object ProjectConfigurations {
    const val applicationId = "com.ggne.royalflush"
    const val compileSdk = 33
    const val targetSdk = 33
    const val minSdk = 26
    val javaVersion = JavaVersion.VERSION_11
    const val versionCode = 1
    const val versionName = "0.0.1"
}