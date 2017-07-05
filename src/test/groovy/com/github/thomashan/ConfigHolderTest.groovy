package com.github.thomashan

import org.junit.Test


class ConfigHolderTest {
    @Test
    void testDevEnvironment() {
        System.setProperty("env", "dev")

        ConfigObject config = ConfigHolder.config()

        assert config.property1 == "property1"
        assert config.property2 == "devProperty"
    }

    @Test
    void testTestEnvironment() {
        System.setProperty("env", "test")

        ConfigObject config = ConfigHolder.config()

        assert config.property1 == "property1"
        assert config.property2 == "testProperty"
    }
}
