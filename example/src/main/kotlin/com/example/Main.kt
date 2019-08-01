package com.example

class Main {

    companion object {

        @JvmStatic
        fun main(args:Array<String>) {
            val tsDefinitions = Main::class.java.getResource("/j2ts/example.ts.d").readText()
            if (tsDefinitions == """
                    export interface AKotlinDataClass {
                        asdf: string;
                        trew: number;
                    }
                """.trimIndent()) {
                println("All ok!!")
            } else {
                println("Bad ts definition result")
                println(tsDefinitions)
                System.exit(1)
            }
        }
    }
}

