package com.vwmin.onebotvwmin.chat.entities

data class GptRequest(
    val model : String = "gpt-3.5-turbo",
    val messages : MutableList<ChatMessage> = ArrayList(),
)
