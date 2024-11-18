// Main.kt
package org.example

import jakarta.annotation.PostConstruct
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.beans.factory.annotation.Autowired

@SpringBootApplication
open class Application {

    @Autowired
    lateinit var helloWorldComponent: HelloWorldComponent

    @Autowired
    lateinit var domainRepoPairOf: DomainRepo<PairOf>

    @Autowired
    lateinit var domainRepoPairOn: DomainRepo<PairOn>

    @PostConstruct
    open fun init() {
        helloWorldComponent.printHelloWorld()

        val jsonStringPairOf = """{"name": "example", "value": 42, "falue": 42}"""
        val eventsPairOf = domainRepoPairOf.decodeEventS(jsonStringPairOf)
        println(eventsPairOf)

        val jsonStringPairOn = """{"name": "example", "value": 42, "nalue": 42}"""
        val eventsPairOn = domainRepoPairOn.decodeEventS(jsonStringPairOn)
        println(eventsPairOn)
    }
}

fun main(args: Array<String>) {
    runApplication<Application>(*args)
}