package org.thomashan

import groovy.transform.PackageScope


final class ConfigHolder {
    static ConfigObject config() {
        String env = System.getProperty("env") ?: "dev"

        ConfigObject defaultConfig = defaultConfig(env)
        ConfigObject externalConfig = externalConfig(env)

        return defaultConfig.merge(externalConfig)
    }

    @PackageScope
    static ConfigObject defaultConfig(String env) {
        URL configUrl = getClass().getResource("/application.groovy")

        return new ConfigSlurper(env).parse((URL) configUrl)
    }

    private static ConfigObject externalConfig(String env) {
        File file = file("${System.getProperty("user.dir")}/application-${env}.groovy")

        return configObject(file, env)
    }

    private static File file(String fileName) {
        return new File(fileName)
    }

    private static ConfigObject configObject(File file, String env) {
        if (file.exists()) {
            return new ConfigSlurper(env).parse(file.toURI().toURL())
        }

        return new ConfigObject()
    }
}
