# gradle-environment-config
[![Build Status](https://travis-ci.org/thomashan/gradle-environment-config.svg)](https://travis-ci.org/thomashan/gradle-environment-config)
[![Quality Gate](https://sonarcloud.io/api/badges/gate?key=com.github.thomashan.gradle-environment-config)](https://sonarcloud.io/dashboard?id=com.github.thomashan.gradle-environment-config)
[![Coverage Status](https://coveralls.io/repos/github/thomashan/gradle-environment-config/badge.svg)](https://coveralls.io/github/thomashan/gradle-environment-config)
[![Codacy Badge](https://api.codacy.com/project/badge/Grade/1984f0cf64464a238c59219751d77794)](https://www.codacy.com/app/thomashan/gradle-environment-config?utm_source=github.com&amp;utm_medium=referral&amp;utm_content=thomashan/gradle-environment-config&amp;utm_campaign=Badge_Grade)

Per environment configuration for the application and gradle build!

Suggestions and feedback is very much appreciated.

## Usage

## Design consideration
* simple
* lightweight
* minimal dependencies


# Overview
This is an example Gradle project which loads the per environments settings from /src/main/resources/application.groovy.
This project inspired from the Grails per environment configurations.

Pass in the environment using the env property name
gradle -Denv=prod test

The default environment value is "dev"
When running tests the environment should switch to "test"
i.e. gradle test
should switch to test environment automatically.

As with Grails the built in environments are
* dev
* test
* prod

Custom environments can be passed in as well.

## Ways to override configuration


## Order of loading configuration files

## Why groovy file for configuration?
Can embed logic

## Dependencies
* java v???
* groovy v???
* gradle v???


Put default configuration in `src/main/resources/application.groovy`

## Examples use cases
### Application environment
### Build environment


## TODO:
* able to override location of application config
* able to override location of build config

## Comparison
* https://github.com/lferenczi/gradle-env-plugin
* https://bitbucket.org/AlexanderBartash/gradle-environments-plugin/wiki/Home
* https://github.com/marceloemanoel/gradle-environments-plugin
