package com.github.thomashan.config

import groovy.transform.PackageScope

import static com.github.thomashan.config.ConfigUtils.configObject
import static com.github.thomashan.config.ConfigUtils.file

final class BuildConfigHolder {
    private static final String PATH = "src/main/resources"

    static ConfigObject config(String projectPath) {
        String env = System.getProperty("buildEnv") ?: "dev"

        return defaultProjectBuildConfig(projectPath, env)
    }

    @PackageScope
    static ConfigObject defaultProjectBuildConfig(String projectPath, String env) {
        File file = file("${projectPath}/${PATH}/build.groovy")

        return configObject(file, env)
    }
}
