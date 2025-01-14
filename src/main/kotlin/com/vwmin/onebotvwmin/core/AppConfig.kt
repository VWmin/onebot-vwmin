package com.vwmin.onebotvwmin.core

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.vwmin.onebotvwmin.chat.GptApi
import com.vwmin.onebotvwmin.core.entities.IOnebotEvent
import com.vwmin.onebotvwmin.core.entities.Message
import com.vwmin.onebotvwmin.core.entities.OnebotEventDeserializer
import com.vwmin.onebotvwmin.core.entities.SegmentMessageDeserializer
import com.vwmin.restproxy.RestProxy
import lombok.Getter
import lombok.Setter
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.client.SimpleClientHttpRequestFactory
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.GsonHttpMessageConverter
import org.springframework.web.client.RestTemplate
import java.net.InetSocketAddress
import java.net.Proxy


@Getter
@Setter
@Configuration
@ConfigurationProperties(prefix = "bot")
class AppConfig{
    var selfId: Long = 0
    var gptKey: String = ""
    var enableProxy: Boolean = false
    var proxyHost: String = ""
    var proxyPort: Int = 0

    @Bean
    fun normalRestTemplate(): RestTemplate {
        val factory = SimpleClientHttpRequestFactory()
        if (enableProxy) {
            val proxy = Proxy(Proxy.Type.HTTP, InetSocketAddress(proxyHost, proxyPort))
            factory.setProxy(proxy)
        }
        return RestTemplate(factory)
    }

    @Bean
    fun gson(): Gson = GsonBuilder()
        .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        .registerTypeAdapter(IOnebotEvent::class.java, OnebotEventDeserializer())
        .registerTypeAdapter(Message::class.java, SegmentMessageDeserializer())
        .create()

    @Bean
    fun gptApi(restTemplate: RestTemplate): GptApi {
        val url = "https://api.deepseek.com"
        return RestProxy(url, GptApi::class.java, restTemplate).api
    }
}