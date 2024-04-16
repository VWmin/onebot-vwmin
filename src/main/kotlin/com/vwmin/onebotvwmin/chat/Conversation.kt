package com.vwmin.onebotvwmin.chat

import com.vwmin.onebotvwmin.chat.entities.ChatMessage

class Conversation private constructor(
    private val prompt :MutableList<ChatMessage> = mutableListOf()
) {

    private var tokens : Int = prompt.sumOf { it.content.length }
    private val conversation :MutableList<ChatMessage> = mutableListOf()

    /***
     * 这个函数的作用是收到回复后记录到对话中，而不是用来发送的
     */
    private fun add(role: String, content: String) {
        if (conversation.size == MAX_CONVERSATION_SIZE) {
            tokens -= conversation.first().content.length
        }

        while (tokens + content.length > MAX_TOKENS && conversation.isNotEmpty()) {
            tokens -= conversation.first().content.length
        }

        tokens += content.length
        conversation.add(ChatMessage(role, content))
    }

    fun iSay(content: String) = add("user", content)

    fun heSay(content: String) = add("assistant", content)

    fun conversation() : List<ChatMessage> = prompt + conversation


    companion object {
        const val MAX_TOKENS = 4000
        const val MAX_CONVERSATION_SIZE = 14
        val chat = Conversation()
    }



}