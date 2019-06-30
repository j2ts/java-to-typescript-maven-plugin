# java-to-typescript-maven-plugin
Create typescript definitions from annotated java (or other JVM language) types
# Work in progress
[![Build Status](https://travis-ci.org/j2ts/java-to-typescript-maven-plugin.svg?branch=master)](https://travis-ci.org/j2ts/java-to-typescript-maven-plugin)
![JDK](https://img.shields.io/badge/JDK-%3E%3D1.8-lightgrey.svg)
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

## Local Nexus
Might prevent you from obtaining the `com.github.ntrrgc:ts-generator` dependency, that is provided by JitPack.
In this case you might need to build using a separate `settings.xml` file (using maven `-s` flag), or by adding JitPack as a repository in your Nexus. 
```bash
mvn clean install -s ./settings.xml -e
```
