package com.github.thomashan.config

import org.gradle.api.Plugin
import org.gradle.api.Project

class ConfigPlugin implements Plugin<Project> {
    void apply(Project project) {
        def config = BuildConfigHolder.config(project.projectDir.absolutePath)
        project.ext.config = BuildConfigHolder.config(project.projectDir.absolutePath)
    }
}
