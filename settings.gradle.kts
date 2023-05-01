@file:Suppress("UnstableApiUsage")

pluginManagement {
    includeBuild("build-logic")
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
include(":feature:feature-detail")
include(":feature:feature-login")
include(":feature:feature-home")
include(":feature:feature-mypage")
include(":feature:feature-teatime")
include(":feature:feature-subway")
include(":domain")
include(":data:data-common")
include(":data:data-subway")
include(":data:data-toilet")