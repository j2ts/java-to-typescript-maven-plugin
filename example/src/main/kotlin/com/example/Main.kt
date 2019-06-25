package com.example

class Main {

    companion object {

        @JvmStatic
        fun main(args:Array<String>) {
            println("Hello main")
            val tsDefinitions = Main::class.java.getResource("./definitions.ts.d").readText()
            assert(tsDefinitions.contains("AKotlinDataClass"))
        }
    }
}

