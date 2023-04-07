import com.ggne.build_logic.ProjectConfigurations
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.plugins.JavaPluginExtension
import org.gradle.kotlin.dsl.configure

class KotlinDomainConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("java-library")
                apply("org.jetbrains.kotlin.jvm")
            }

            extensions.configure<JavaPluginExtension> {
                apply {
                    sourceCompatibility = ProjectConfigurations.javaVersion
                    targetCompatibility = ProjectConfigurations.javaVersion
                }
            }
        }
    }
}