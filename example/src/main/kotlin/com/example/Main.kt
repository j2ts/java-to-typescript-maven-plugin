package com.example

class Main {

    companion object {

        @JvmStatic
        fun main(args:Array<String>) {
            try {
                val tsDefinitions = Main::class.java.getResource("/j2ts/example.ts.d").readText()
                assert(tsDefinitions.contains("AKotlinDataClass"))
                println("OK!")
            } catch (e: Exception) {
                e.printStackTrace()
                System.exit(1)
            }
        }
    }
}

