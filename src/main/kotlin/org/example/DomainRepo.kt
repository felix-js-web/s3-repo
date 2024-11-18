package org.example

import kotlinx.serialization.json.Json
import kotlinx.serialization.KSerializer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

// DomainRepo.kt
@Component
class DomainRepo<T>(@Autowired private val serializer: KSerializer<T>) {
    fun decodeEventS(jsonString: String): List<DomainEvent<T>> {
        val domainEvent = Json.decodeFromString(serializer, jsonString)
        return listOf(DomainEvent(domainEvent = domainEvent, name = "asd", value = 1))
    }
}