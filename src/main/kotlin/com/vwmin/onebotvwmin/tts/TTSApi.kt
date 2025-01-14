package com.vwmin.onebotvwmin.tts

import com.vwmin.onebotvwmin.tts.entities.TTSRequest
import com.vwmin.restproxy.annotations.Json

fun interface TTSApi {
    fun tts(@Json body: TTSRequest): String
}