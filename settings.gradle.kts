pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://naver.jfrog.io/artifactory/maven/")
        maven("https://jitpack.io/")
    }
}
rootProject.name = "RoyalFlush"
include(":app")
include(":feature:feature-common")
include(":feature:feature-map")
include(":feature:feature-subway")
include(":feature:feature-teatime")
include(":feature:feature-more")
include(":feature:feature-detail")
include(":feature:feature-login")
include(":data:data-common")
include(":data:data-toilet")
include(":data:data-subway")
include(":domain")
