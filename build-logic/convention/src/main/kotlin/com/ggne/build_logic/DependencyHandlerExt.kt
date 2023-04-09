package com.ggne.build_logic

import org.gradle.api.artifacts.Dependency
import org.gradle.api.artifacts.ProjectDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.provider.Provider
import java.util.*

internal fun <T> DependencyHandler.implementation(
    dependencyNotation: Optional<Provider<T>>
): Dependency? = add("implementation", dependencyNotation.get())

internal fun DependencyHandler.implementation(
    projectDependency: ProjectDependency
): Dependency? = add("implementation", projectDependency)

internal fun <T> DependencyHandler.debugImplementation(
    dependencyNotation: Optional<Provider<T>>
): Dependency? = add("debugImplementation", dependencyNotation.get())

internal fun <T> DependencyHandler.kapt(
    dependencyNotation: Optional<Provider<T>>
): Dependency? = add("kapt", dependencyNotation.get())

internal fun <T> DependencyHandler.api(
    dependencyNotation: Provider<T>
): Dependency? = add("api", dependencyNotation)
