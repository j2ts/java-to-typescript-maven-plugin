#!/usr/bin/env bash

set -e

mvn clean install
mvn clean package -f example/pom.xml
# TODO java -cp example/target/example-0.0.0-SNAPSHOT-jar-with-dependencies.jar
