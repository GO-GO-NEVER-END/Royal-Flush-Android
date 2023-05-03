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
                apply("dagger.hilt.android.plugin")
                apply("kotlin-kapt")
            }

            val libs = findVersionCatalog()

            dependencies {
                implementation(libs.findLibrary("hilt-android"))
                kapt(libs.findLibrary("hilt-compiler"))
            }

            kapt {
                correctErrorTypes = true
            }
        }
    }

}