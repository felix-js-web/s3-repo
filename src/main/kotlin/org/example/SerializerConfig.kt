package org.example

import kotlinx.serialization.KSerializer
import kotlinx.serialization.serializer
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Primary

// SerializerConfig.kt
// SerializerConfig.kt
@Configuration
open class SerializerConfig {

    @Bean
    @Primary
    open fun pairOfSerializer(): KSerializer<PairOf> {
        return PairOf.serializer()
    }

    @Bean
    open fun pairOnSerializer(): KSerializer<PairOn> {
        return PairOn.serializer()
    }

    @Bean
    open fun domainRepoPairOf(pairOfSerializer: KSerializer<PairOf>): DomainRepo<PairOf> {
        return DomainRepo(pairOfSerializer)
    }

    @Bean
    open fun domainRepoPairOn(pairOnSerializer: KSerializer<PairOn>): DomainRepo<PairOn> {
        return DomainRepo(pairOnSerializer)
    }
}