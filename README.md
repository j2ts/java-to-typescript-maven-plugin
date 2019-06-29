# java-to-typescript-maven-plugin
Create typescript definitions from annotated java (or other JVM language) types
# Work in progress
[![Build Status](https://travis-ci.org/j2ts/java-to-typescript-maven-plugin.svg?branch=master)](https://travis-ci.org/j2ts/java-to-typescript-maven-plugin)
![JDK](https://img.shields.io/badge/JDK-%3E%3D1.8-lightgrey.svg)
```xml
<project>
    <!-- ... -->
    <repositories>
        <repository>
            <id>jitpack.io</id>
            <url>https://jitpack.io</url>
        </repository>
    </repositories>
    <plugins>
        <plugin>
            <groupId>com.github.j2ts</groupId>
            <artifactId>java-to-typescript-maven-plugin</artifactId>
            <configuration>
                <annotation>com.example.AKotLinAnnotation</annotation>
            </configuration>
        </plugin>
    </plugins>
</project>
```
