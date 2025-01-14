package com.vwmin.onebotvwmin

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration
import org.springframework.boot.runApplication

@SpringBootApplication(exclude = [JacksonAutoConfiguration::class])
class OnebotVwminApplication

fun main(args: Array<String>) {
    runApplication<OnebotVwminApplication>(*args)
}
