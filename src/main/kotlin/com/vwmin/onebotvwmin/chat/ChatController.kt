package com.vwmin.onebotvwmin.chat

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.arguments.multiple
import com.vwmin.onebotvwmin.core.CommandController
import com.vwmin.onebotvwmin.core.MessageBuilder
import com.vwmin.onebotvwmin.core.QuickOperation
import com.vwmin.onebotvwmin.core.entities.QuickReply

@CommandController(bind = "chat")
class ChatController(private val api: GptApi) :CliktCommand(), QuickOperation {

    val words : List<String> by argument(help = "words to gpt").multiple(required = true)

    override fun run() {
        println("[ChatController] got words: $words")
    }

    override fun reply(): QuickReply {

        val content = words.joinToString(" ")
        val response = api.chat(GptRequestBuilder()
            .conversation(Conversation.chat.conversation())
            .user(content)
            .build())

        Conversation.chat.iSay(content)
        Conversation.chat.heSay(response.choices[0].message.content)

        org.springframework.http.HttpMethod.POST

        return QuickReply(
            reply = MessageBuilder()
                .plaintext(response.choices[0].message.content)
                .build(),
            atSender = true
        )
    }
}