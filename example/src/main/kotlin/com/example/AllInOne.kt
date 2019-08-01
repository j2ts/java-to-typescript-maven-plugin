package com.example

import kotlin.annotation.AnnotationRetention.RUNTIME

@AKotLinAnnotation
data class AKotlinDataClass(val asdf: String, val trew: Long?)

@Retention(RUNTIME)
annotation class AKotLinAnnotation
