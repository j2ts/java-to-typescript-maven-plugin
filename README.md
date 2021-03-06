# java-to-typescript-maven-plugin
Create typescript definitions from annotated java (or other JVM language) types

[![AppVeyor branch](https://img.shields.io/appveyor/ci/jensim/java-to-typescript-maven-plugin/master.svg?label=Windows%20build)](https://ci.appveyor.com/project/jensim/java-to-typescript-maven-plugin)
[![Travis (.org) branch](https://img.shields.io/travis/j2ts/java-to-typescript-maven-plugin/master.svg?label=Linux%20build)](https://travis-ci.org/j2ts/java-to-typescript-maven-plugin)
![JDK](https://img.shields.io/badge/JDK-%3E%3D1.8-lightgrey.svg)
[![Lines of Code](https://sonarcloud.io/api/project_badges/measure?project=com.github.j2ts%3Ajava-to-typescript-maven-plugin&metric=ncloc)](https://sonarcloud.io/dashboard?id=com.github.j2ts%3Ajava-to-typescript-maven-plugin)
[![Coverage](https://sonarcloud.io/api/project_badges/measure?project=com.github.j2ts%3Ajava-to-typescript-maven-plugin&metric=coverage)](https://sonarcloud.io/dashboard?id=com.github.j2ts%3Ajava-to-typescript-maven-plugin)
[![Project Status: Active – The project has reached a stable, usable state and is being actively developed.](https://www.repostatus.org/badges/latest/active.svg)](https://www.repostatus.org/#active)
[![Maven Central](https://img.shields.io/maven-central/v/com.github.j2ts/java-to-typescript-maven-plugin.svg)](https://search.maven.org/artifact/com.github.j2ts/java-to-typescript-maven-plugin/)
[![License](https://img.shields.io/badge/License-Apache%202.0-blue.svg)](LICENSE)

## Usage
```xml
<project>
    <plugins>
        <plugin>
            <groupId>com.github.j2ts</groupId>
            <artifactId>java-to-typescript-maven-plugin</artifactId>
            <version>${j2ts.version}</version>
            <executions><execution><goals><goal>j2ts</goal></goals></execution></executions>
            <configuration>
                <annotation>com.example.AKotlinAnnotation</annotation>
                <!-- Optional -->
                <outputFileRef>${project.build.outputDirectory}/j2ts/${project.artifactId}.ts.d</outputFileRef>
            </configuration>
        </plugin>
    </plugins>
</project>
```

## Nullable member properties
It seems that kotlin nullability doesn't load with the URLClassLoader `KType#isMarkedNullable` always returns false, and `ts-generator` needs that info to generate correctly 

## Local Nexus
Might prevent you from obtaining the `com.github.ntrrgc:ts-generator` dependency, that is provided by JitPack.
In this case you might need to build using a separate `settings.xml` file (using maven `-s` flag), or by adding JitPack as a repository in your Nexus. 
```bash
mvn clean install -s ./settings.xml -e
```

## Dependencies
* [org.reflections](https://github.com/ronmamo/reflections/)
[![BSD](https://img.shields.io/badge/Licence-The%20New%20BSD%20Licence-yellow.svg)](http://www.opensource.org/licenses/bsd-license.html)
[![WTFPL](https://img.shields.io/badge/Licence-WTFPL-red.svg)](http://www.wtfpl.net/)
* [ts-generator](https://github.com/ntrrgc/ts-generator) 
[![Apache-2.0](https://img.shields.io/badge/Licence-Apache--2.0-blue.svg)](https://github.com/ntrrgc/ts-generator/blob/master/LICENSE.md)
