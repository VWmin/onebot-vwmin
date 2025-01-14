package com.vwmin.onebotvwmin.core

import com.google.gson.Gson
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.converter.json.GsonHttpMessageConverter

@Configuration
internal class GsonConfig {
    @Bean
    fun gsonHttpMessageConverter(gson: Gson): GsonHttpMessageConverter = GsonHttpMessageConverter(gson)
}