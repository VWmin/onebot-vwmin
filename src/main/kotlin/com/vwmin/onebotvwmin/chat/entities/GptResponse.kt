package com.vwmin.onebotvwmin.chat.entities

data class GptResponse(
    var id: String,
    var `object`: String,
    var created: Int,
    var model: String,
    var usage: Usage,
    var choices: List<Choice>





)
