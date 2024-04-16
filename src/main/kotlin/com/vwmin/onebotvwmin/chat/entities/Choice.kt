package com.vwmin.onebotvwmin.chat.entities

data class Choice(
    var message: ChatMessage,
    var finishReason: String,
    var index: Int
)
