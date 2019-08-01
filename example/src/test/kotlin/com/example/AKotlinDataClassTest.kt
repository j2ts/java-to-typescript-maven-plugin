package com.example

import org.junit.Assert.assertEquals
import kotlin.reflect.full.memberProperties
import kotlin.test.Test

class AKotlinDataClassTest {

    @Test
    fun nullable() {
        val properties = AKotlinDataClass::class.memberProperties
        properties.forEach { println("${it.name}:${it.returnType}") }
        val nullable = properties.filter { it.returnType.isMarkedNullable }.count()
        assertEquals(1, nullable)
    }
}
