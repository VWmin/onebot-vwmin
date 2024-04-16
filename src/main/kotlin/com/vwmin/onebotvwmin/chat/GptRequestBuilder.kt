package com.vwmin.onebotvwmin.chat

import com.vwmin.onebotvwmin.chat.entities.ChatMessage
import com.vwmin.onebotvwmin.chat.entities.GptRequest

class GptRequestBuilder {
    private val body = GptRequest()

    /***
     * 必须先调用[conversation]读取上下文
     */
    fun user(content: String): GptRequestBuilder {
        body.messages.add(ChatMessage(role = "user", content = content))
        return this
    }

    fun conversation(conversation: List<ChatMessage>): GptRequestBuilder {
        body.messages.addAll(conversation)
        return this
    }

    fun system(content: String): GptRequestBuilder {
        body.messages.add(ChatMessage(role = "system", content = content))
        return this
    }

    fun build(): GptRequest = body
}