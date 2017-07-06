package com.github.thomashan.config

import org.junit.After
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test

class BuildConfigHolderTests {
    private static final File BUILD_CONFIG_FILE = new File("src/main/resources/build.groovy")

    @BeforeClass
    static void setUpBeforeClass() {
        BUILD_CONFIG_FILE << '''
buildProperty1 = "defaultValue"

environments {
    customBuildEnv {
        buildProperty1 = "customBuildEnvValue"
    }
}
'''
    }

    @AfterClass
    static void tearDownAfterClass() {
        BUILD_CONFIG_FILE.delete()
    }

    @After
    void tearDown() {
        System.clearProperty("buildEnv")
    }

    @Test
    void testDefaultProjectBuildConfig_IsNotNull() {
        assert BuildConfigHolder.defaultProjectBuildConfig(".", "dev") != null
    }

    @Test
    void testConfig_DefaultsToDevEnvironment() {
        ConfigObject config = BuildConfigHolder.config(".")

        assert config.buildProperty1 == "defaultValue"
    }

    @Test
    void testConfig_CustomBuildEnv() {
        System.setProperty("buildEnv", "customBuildEnv")

        ConfigObject config = BuildConfigHolder.config(".")

        assert config.buildProperty1 == "customBuildEnvValue"
    }
}
