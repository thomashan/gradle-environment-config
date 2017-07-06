# gradle-environment-config
Per environment Gradle builds

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

## Design consideration
* simple
* lightweight
* minimal dependencies

Put default configuration in `src/main/resources/application.groovy`

## Examples use cases
### Application environment
### Build environment


## TODO:
* able to override location of application config
* able to override location of build config
