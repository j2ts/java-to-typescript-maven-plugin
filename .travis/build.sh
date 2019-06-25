#!/usr/bin/env bash

set -e

mvn clean install -s ./.travis/maven_settings.xml
mvn clean package -f example/pom.xml -s ./.travis/maven_settings.xml
# TODO java -cp example/target/example-0.0.0-SNAPSHOT-jar-with-dependencies.jar
