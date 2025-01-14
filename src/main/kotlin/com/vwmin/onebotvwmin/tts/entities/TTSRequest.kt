package com.vwmin.onebotvwmin.tts.entities

data class TTSRequest (
    val method : String = "POST",
    val body: Body
)

data class Body (
    val character : String,
    val emotion: String, // need to be url encoded
    val text: String,
)