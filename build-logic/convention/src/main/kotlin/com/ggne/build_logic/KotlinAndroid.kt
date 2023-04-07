package com.ggne.build_logic

import com.android.build.api.dsl.CommonExtension
import org.gradle.api.Action
import org.gradle.api.Project
import org.gradle.api.plugins.ExtensionAware
import org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
import org.jetbrains.kotlin.gradle.plugin.KaptExtension

internal fun Project.configureKotlinAndroid(
    commonExtension: CommonExtension<*, *, *, *>
) {
    commonExtension.apply {
        compileSdk = ProjectConfigurations.compileSdk

        defaultConfig {
            minSdk = ProjectConfigurations.minSdk
        }

        compileOptions {
            sourceCompatibility = ProjectConfigurations.javaVersion
            targetCompatibility = ProjectConfigurations.javaVersion
        }

        kotlinOptions {
            jvmTarget = ProjectConfigurations.javaVersion.toString()
        }

        dataBinding {
            enable = true
        }
    }
}

fun CommonExtension<*, *, *, *>.kotlinOptions(block: KotlinJvmOptions.() -> Unit) {
    (this as ExtensionAware).extensions.configure("kotlinOptions", block)
}

fun Project.kapt(
    configure: Action<KaptExtension>
) {
    (this as ExtensionAware).extensions.configure("kapt", configure)
}