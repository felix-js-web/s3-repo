package org.example

data class DomainEvent<P>(
    val domainEvent: P?,
    val name: String,
    val value: Int,
)