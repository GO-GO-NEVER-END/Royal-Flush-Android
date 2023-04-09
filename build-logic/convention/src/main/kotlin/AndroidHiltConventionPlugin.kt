import com.ggne.build_logic.findVersionCatalog
import com.ggne.build_logic.implementation
import com.ggne.build_logic.kapt
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidHiltConventionPlugin: Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("kotlin-kapt")
                apply("dagger.hilt.android.plugin")
            }

            val libs = findVersionCatalog()

            dependencies {
                implementation(libs.findLibrary("dagger-hilt-android"))
                kapt(libs.findLibrary("dagger-hilt-android-compiler"))
                implementation(libs.findLibrary("androidx-hilt-navigation-fragment"))
            }

            kapt {
                correctErrorTypes = true
            }
        }
    }

}