package com.vwmin.onebotvwmin.core.entities

data class QuickReply(
    val reply: List<Message>,
    val atSender: Boolean = false
) {
    companion object{
        fun empty():QuickReply = QuickReply(emptyList())
    }
}
