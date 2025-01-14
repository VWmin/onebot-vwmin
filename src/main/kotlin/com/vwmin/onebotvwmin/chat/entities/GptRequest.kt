package com.vwmin.onebotvwmin.chat.entities

data class GptRequest(
    val model : String = "deepseek-chat",
    val messages : MutableList<ChatMessage> = ArrayList(),
)
