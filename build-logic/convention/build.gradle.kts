plugins {
    `kotlin-dsl`
}


java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

dependencies {
    compileOnly(libs.android.gradle.plugin)
    compileOnly(libs.kotlin.gradle.plugin)
    compileOnly(libs.hilt.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "ggne.android.application"
            implementationClass = "AndroidApplicationConventionPlugin"
        }

        register("androidLibrary") {
            id = "ggne.android.library"
            implementationClass = "AndroidLibraryConventionPlugin"
        }

        register("androidHilt") {
            id = "ggne.android.hilt"
            implementationClass = "AndroidHiltConventionPlugin"
        }

        register("androidData") {
            id = "ggne.android.data"
            implementationClass = "AndroidDataConventionPlugin"
        }

        register("kotlinDomain") {
            id = "ggne.kotlin.domain"
            implementationClass = "KotlinDomainConventionPlugin"
        }

        register("androidFeature") {
            id = "ggne.android.feature"
            implementationClass = "AndroidFeatureConventionPlugin"
        }
    }
}