package com.vwmin.onebotvwmin.chat

import com.vwmin.onebotvwmin.chat.entities.GptRequest
import com.vwmin.onebotvwmin.chat.entities.GptResponse
import com.vwmin.restproxy.annotations.Header
import com.vwmin.restproxy.annotations.Headers
import com.vwmin.restproxy.annotations.Json
import com.vwmin.restproxy.annotations.POST

interface GptApi {
    @POST("/chat/completions")
    @Headers(headers = [
        Header(k = "Authorization", v = "Bearer {place your gpt key here}"),
        Header(k = "Content-Type", v = "application/json")
    ])
    fun chat(@Json body: GptRequest): GptResponse
}