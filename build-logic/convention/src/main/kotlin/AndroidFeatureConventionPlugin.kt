import com.ggne.build_logic.findVersionCatalog
import com.ggne.build_logic.implementation
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.dependencies

class AndroidFeatureConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("ggne.android.library")
                apply("ggne.android.hilt")
            }

            val libs = findVersionCatalog()

            dependencies {
                implementation(libs.findBundle("android-base"))
                implementation(libs.findBundle("android-feature-base"))
            }
        }
    }
}