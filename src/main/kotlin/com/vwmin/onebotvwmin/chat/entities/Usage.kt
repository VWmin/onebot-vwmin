package com.vwmin.onebotvwmin.chat.entities

data class Usage(
    var promptTokens: Int,
    var completionTokens: Int,
    var totalTokens: Int,
)
