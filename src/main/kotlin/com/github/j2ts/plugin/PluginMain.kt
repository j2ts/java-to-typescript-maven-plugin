package com.github.j2ts.plugin

import me.ntrrgc.tsGenerator.TypeScriptGenerator
import me.ntrrgc.tsGenerator.VoidType.UNDEFINED
import org.apache.maven.plugin.AbstractMojo
import org.apache.maven.plugins.annotations.LifecyclePhase.COMPILE
import org.apache.maven.plugins.annotations.Mojo
import org.apache.maven.plugins.annotations.Parameter
import org.apache.maven.project.MavenProject
import org.reflections.Reflections
import java.io.File
import java.net.URLClassLoader

@Mojo(name = "j2ts", defaultPhase = COMPILE)
class PluginMain : AbstractMojo() {

    @Parameter(readonly = true, defaultValue = "\${project}")
    lateinit var project: MavenProject

    @Parameter(property = "j2ts.classDir", required = false)
    var classDir: String? = null

    @Parameter(property = "j2ts.outputFile")
    var outputFileRef: String? = null
    private val outputFile: File by lazy {
        File(outputFileRef ?: "${project.build.outputDirectory}/j2ts/${project.artifactId}.ts.d")
    }

    @Parameter(property = "j2ts.annotation", required = true)
    lateinit var annotation: String

    @Suppress("UNCHECKED_CAST")
    private val annotationClass: Class<out Annotation> by lazy {
        try {
            loader.loadClass(annotation) as Class<out Annotation>
        } catch (e: Exception) {
            log.error("Annotation '$annotation' was unable to load. Exception type: '${e.javaClass}'")
            throw e
        }
    }

    private val concreteBuildDir: String by lazy {
        try {
            classDir ?: project.build.outputDirectory
        } catch (e: Exception) {
            val ref = if (classDir == null) "'project.build.outputDirectory'" else "'j2ts.buildDir'"
            log.error("Was unable to read property $ref")
            throw e
        }
    }

    private val loader: URLClassLoader by lazy {
        try {
            URLClassLoader(arrayOf(File(concreteBuildDir).toURI().toURL()))
        } catch (e: Exception) {
            log.error("Was unable to create classloader")
            throw e
        }
    }

    override fun execute() {
        val r = Reflections(loader)
        val a = r.getTypesAnnotatedWith(annotationClass).map { it.kotlin }.toSet()
        val text = TypeScriptGenerator(rootClasses = a, voidType = UNDEFINED)
                .individualDefinitions
                .joinToString("\n\n") { "export $it" }
        log.info(text)
        outputFile.parentFile.mkdirs()
        outputFile.writeText(text)
    }
}
