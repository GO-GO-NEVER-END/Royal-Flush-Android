import com.ggne.build_logic.findVersionCatalog
import com.ggne.build_logic.implementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = findVersionCatalog()

            with(pluginManager) {
                apply("ggne.android.library")
                apply("ggne.android.hilt")
                apply("androidx.navigation.safeargs.kotlin")
            }

            dependencies {
                implementation(libs.findBundle("navigation"))
                implementation(libs.findBundle("android-feature-base"))
            }
        }
    }
}