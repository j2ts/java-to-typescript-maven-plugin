package com.github.j2ts.plugin

import org.junit.Rule
import org.junit.rules.TemporaryFolder
import java.io.File
import kotlin.test.Test
import kotlin.test.assertEquals

class PluginMainTest {

    @Rule
    @JvmField
    val tmpDir = TemporaryFolder()

    @Test
    fun executeTest() {
        // given
        val out = File(tmpDir.root, "output.d.ts")
        val target = PluginMain()
        target.outputFileRef = out.absolutePath
        target.annotation = ToTypescript::class.java.canonicalName
        target.classDir = File("target/test-classes").absolutePath

        // when
        target.execute()

        // then
        val output = out.readText()
        assertEquals("""
            export interface Bar {
                bar: number | undefined;
                foo: number;
                foo2: number | undefined;
                s: string;
                sum: number;
                summed: number | undefined;
                t: string | undefined;
            }

            export interface Foo {
                bar: Bar;
                name: string | undefined;
                tags: string[];
            }
        """.trimIndent(), output)
    }
}

annotation class ToTypescript

@ToTypescript
data class Foo(
        val name: String? = null,
        val tags: List<String> = emptyList(),
        val bar: Bar
)

data class Bar(
        val foo: Long,
        val foo2: Long?,
        val bar: Int? = null,
        val sum: Double = 0.0,
        val summed: Double?,
        val s: String,
        val t: String?
)
