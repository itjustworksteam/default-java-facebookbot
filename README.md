# default-java-facebookbot

[![Build Status](https://travis-ci.org/itjustworksteam/default-java-facebookbot.svg?branch=master)](https://travis-ci.org/itjustworksteam/default-java-facebookbot)

## GETTING STARTED

On Facebook follow this simple guide: https://developers.facebook.com/docs/messenger-platform/guides/setup

On Your Laptop / Server

* You have to install java oracle jdk 8 to continue
* clone this repo
* compile it with: ```./gradlew clean check stage```
* remember to set up this environment variables: ```PORT```, ```VERIFY_TOKEN``` e ```BOT_TOKEN```
* run it with: ```java -cp build/libs/facebookbot.jar it.itjustworks.yourserver.server.Server```
* run tests with: ```./gradlew clean check jacocoTestReport```
