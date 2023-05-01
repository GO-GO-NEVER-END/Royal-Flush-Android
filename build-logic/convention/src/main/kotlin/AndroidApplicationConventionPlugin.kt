import com.android.build.api.dsl.ApplicationExtension
import com.ggne.build_logic.ProjectConfigurations
import com.ggne.build_logic.configureKotlinAndroid
import com.ggne.build_logic.findVersionCatalog
import com.ggne.build_logic.implementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.dependencies

@Suppress("UnstableApiUsage")
class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            val libs = findVersionCatalog()
            dependencies {
                implementation(libs.findBundle("navigation"))
                implementation(libs.findBundle("android-feature-base"))
            }

            extensions.configure<ApplicationExtension> {
                configureKotlinAndroid(this)
                defaultConfig {
                    applicationId = ProjectConfigurations.applicationId
                    targetSdk = ProjectConfigurations.targetSdk
                    versionCode = ProjectConfigurations.versionCode
                    versionName = ProjectConfigurations.versionName
                    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                }

                buildTypes {
                    release {
                        isMinifyEnabled = true
                        proguardFiles(
                            getDefaultProguardFile("proguard-android-optimize.txt"),
                            "proguard-rules.pro"
                        )
                    }
                }
            }
        }
    }
}