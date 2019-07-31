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
                bar: number | null;
                foo: number;
                s: string;
                sum: number;
                summed: number | null;
                t: string | null;
            }

            export interface Foo {
                bar: Bar;
                name: string | null;
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
        val bar: Int? = null,
        val sum: Double = 0.0,
        val summed: Double?,
        val s: String,
        val t: String?
)
