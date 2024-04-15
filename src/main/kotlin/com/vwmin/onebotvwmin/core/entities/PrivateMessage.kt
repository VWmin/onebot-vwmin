package com.vwmin.onebotvwmin.core.entities

data class PrivateMessage(
    override val selfId: Long,
    override val time: Long,
    override val postType: String,
    val userId: Long,
    val messageId: Long,
    val realId: Long,
    val messageType: String,
    val sender: Sender,
    val rawMessage: String,
    val font: Long,
    val subType: String,
    val message: List<Message>,
    val messageFormat: String,
) : OnebotEvent


