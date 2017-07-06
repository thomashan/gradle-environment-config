package com.github.thomashan.config

final class ConfigUtils {
    static File file(String fileName) {
        return new File(fileName)
    }

    static ConfigObject configObject(File file, String env) {
        if (file.exists()) {
            return new ConfigSlurper(env).parse(file.toURI().toURL())
        }

        return new ConfigObject()
    }
}
