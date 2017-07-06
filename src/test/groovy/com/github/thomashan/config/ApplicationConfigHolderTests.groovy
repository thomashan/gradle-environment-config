package com.github.thomashan.config

import org.junit.After
import org.junit.Test

class ApplicationConfigHolderTests {
    private static final File EXTERNAL_CONFIG_FILE = new File("application-test.groovy")

    @After
    void tearDown() {
        System.clearProperty("env")

        if (EXTERNAL_CONFIG_FILE.exists()) {
            EXTERNAL_CONFIG_FILE.delete()
        }
    }

    @Test
    void testDefaultApplicationConfig_IsNotNull() {
        assert ApplicationConfigHolder.defaultApplicationConfig("dev") != null
    }

    @Test
    void testConfig_DefaultsToDev() {
        ConfigObject config = ApplicationConfigHolder.config()

        assert config.property1 == "property1"
        assert config.property2 == "devProperty"
    }

    @Test
    void testConfig_TestEnvironment() {
        System.setProperty("env", "test")

        ConfigObject config = ApplicationConfigHolder.config()

        assert config.property1 == "property1"
        assert config.property2 == "testProperty"
    }

    @Test
    void testExternalFile_OverridesDefaultConfiguration() {
        EXTERNAL_CONFIG_FILE << '''
property2="external"
'''
        System.setProperty("env", "test")

        ConfigObject config = ApplicationConfigHolder.config()

        assert config.property2 == "external"
    }
}
