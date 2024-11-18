package org.example

import org.springframework.stereotype.Component
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json

@Component
class HelloWorldComponent {
    fun printHelloWorld() {
        println("Hello, World!")

        val jsonString = """{"name": "example", "value": 42, "falue":43}"""

        // Deserialize JSON string to PairOf object
        val pairOf: PairOf = Json.decodeFromString(jsonString)

        // Print the deserialized object
        println(pairOf)
    }
}