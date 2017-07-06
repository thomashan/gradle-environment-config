package com.github.thomashan.config

import groovy.transform.PackageScope

import static com.github.thomashan.config.ConfigUtils.configObject
import static com.github.thomashan.config.ConfigUtils.file

final class ApplicationConfigHolder {
    static ConfigObject config() {
        String env = System.getProperty("env") ?: "dev"

        ConfigObject defaultConfig = defaultApplicationConfig(env)
        ConfigObject externalConfig = externalConfig(env)

        return defaultConfig.merge(externalConfig)
    }

    @PackageScope
    static ConfigObject defaultApplicationConfig(String env) {
        File defaultApplicationConfigFile = new File(ApplicationConfigHolder.classLoader.getResource("application.groovy").toURI())

        return configObject(defaultApplicationConfigFile, env)
    }

    private static ConfigObject externalConfig(String env) {
        File file = file("${System.getProperty("user.dir")}/application-${env}.groovy")

        return configObject(file, env)
    }
}
