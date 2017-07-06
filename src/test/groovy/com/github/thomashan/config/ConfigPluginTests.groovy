package com.github.thomashan.config

import org.gradle.api.Project
import org.gradle.testfixtures.ProjectBuilder
import org.junit.After
import org.junit.Before
import org.junit.Test

class ConfigPluginTests {
    private static final BUILD_CONFIG = "src/main/resources/build.groovy"
    private File buildConfigFile
    private Project project

    @Before
    void setUp() {
        project = ProjectBuilder.builder().build()
        buildConfigFile = new File("${project.projectDir}/${BUILD_CONFIG}")
        buildConfigFile.parentFile.mkdirs()

        buildConfigFile.text = '''
buildProperty1 = "defaultValue"

environments {
    customBuildEnv {
        buildProperty1 = "customBuildEnvValue"
    }
}
'''
    }

    @After
    void tearDown() {
        System.clearProperty("buildEnv")

        buildConfigFile.delete()
    }

    @Test
    void testConfigPlugin_AddsConfigToBuildScripts() {
        project.pluginManager.apply("com.github.thomashan.config")

        assert project.config != null
    }

    @Test
    void testConfigPlugin_AddsDefaultBuildConfig() {
        project.pluginManager.apply("com.github.thomashan.config")

        assert project.config.buildProperty1 == "defaultValue"
    }

    @Test
    void testConfigPlugin_CustomBuildConfig() {
        System.setProperty("buildEnv", "customBuildEnv")
        project.pluginManager.apply("com.github.thomashan.config")

        assert project.config.buildProperty1 == "customBuildEnvValue"
    }
}
