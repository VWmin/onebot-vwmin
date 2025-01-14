package com.vwmin.onebotvwmin.core.entities

data class QuickReply(
    val reply: List<Message>,
    val atSender: Boolean = false
) : IQuickReply
