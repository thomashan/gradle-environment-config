# gradle-environment-config
[![Build Status](https://travis-ci.org/thomashan/gradle-environment-config.svg)](https://travis-ci.org/thomashan/gradle-environment-config)
[![Quality Gate](https://sonarcloud.io/api/badges/gate?key=com.github.thomashan.config.gradle-environment-config)](https://sonarcloud.io/dashboard?id=com.github.thomashan.config.gradle-environment-config)
[![Coverage Status](https://coveralls.io/repos/github/thomashan/gradle-environment-config/badge.svg)](https://coveralls.io/github/thomashan/gradle-environment-config)

Per environment configuration for the application and gradle build!

Suggestions and feedback is very much appreciated.

## Quick start
This plugin inspired from the Grails per environment configurations.

### Application Config
Put the application configuration in `src/main/resources/application.groovy`
```groovy
key1 = value1
key2 = value2
environments {
    customEnvironment {
        key2 = customEnvironmentValue2        
    }
}
```

Inside the application code you can reference the config
```groovy
import com.github.thomashan.config.ApplicationConfigHolder

ConfigObject config = ApplicationConfigHolder.config()
String key1Value = config.key1
```
The value of key1Value would change depending on the `-Denv=${ENVIRONMENT}`. 
`./gradle test -Denv=test`
### Build config
The build script `build.gradle` won't have access to the application config file `src/main/resources/application.groovy`
because it's not in the classpath.
You can put configuration in `src/main/resources/build.groovy` for `build.gradle` to consume.
```groovy
buildKey1 = value1
buildKey2 = value2
environments {
    customEnvironment {
        buildKey2 = customEnvironmentValue2        
    }
}
```
Inside `build.gradle` you can reference configuration in `build.groovy` with the config property
For example
```groovy
println config.buildKey1
```

## Design consideration
* simple
* lightweight
* minimal dependencies

## Ways to override configuration


## Order of loading configuration files

## Why groovy file for configuration?
Can embed logic

## Dependencies
* java 1.8+
* groovy 2.4+
* gradle 4+

Put default configuration in `src/main/resources/application.groovy`

## Examples use cases
### Application environment
### Build environment


## TODO:
* able to override location of application config
* able to override location of build config
* when running tests (i.e. `./gradlew test` `./gradlew check`) should switch to test environment automatically.

## Comparison
* https://github.com/lferenczi/gradle-env-plugin
* https://bitbucket.org/AlexanderBartash/gradle-environments-plugin/wiki/Home
* https://github.com/marceloemanoel/gradle-environments-plugin
