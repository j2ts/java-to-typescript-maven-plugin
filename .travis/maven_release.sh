#!/usr/bin/env bash

set -e
set -v

openssl aes-256-cbc -K $2 -iv $3 -in .travis/gpg/jens.brimfors-secret-gpg.key.enc -out jens.brimfors-secret-gpg.key -d
gpg --import .travis/gpg/jens.brimfors-public-gpg.key
gpg --import jens.brimfors-secret-gpg.key
gpg --import-ownertrust .travis/gpg/jens.brimfors-ownertrust-gpg.txt
cp .travis/maven_settings.xml $HOME/.m2/settings.xml

mvn -B -e release:update-versions -DdevelopmentVersion=$1-SNAPSHOT
git add pom.xml
git commit -m "Setting release version"

mvn -B release:prepare
mvn release:perform
