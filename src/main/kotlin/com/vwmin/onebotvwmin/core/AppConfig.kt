package com.vwmin.onebotvwmin.core

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.vwmin.onebotvwmin.core.entities.OnebotEvent
import com.vwmin.onebotvwmin.core.entities.OnebotEventDeserializer
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class AppConfig {
    @Bean
    fun gson(): Gson = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .registerTypeAdapter(OnebotEvent::class.java, OnebotEventDeserializer())
        .create()
}