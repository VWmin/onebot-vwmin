package com.vwmin.onebotvwmin.echo

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.arguments.multiple
import com.vwmin.onebotvwmin.core.CommandController
import com.vwmin.onebotvwmin.core.MessageBuilder
import com.vwmin.onebotvwmin.core.QuickOperation
import com.vwmin.onebotvwmin.core.entities.QuickReply

@CommandController(bind = "echo")
class EchoController : CliktCommand(), QuickOperation {

    val words: List<String> by argument(help = "words to echo").multiple(required = false)

    override fun run() {
        println("[EchoController] got words: $words")
    }

    override fun reply(): QuickReply {
        return QuickReply(
            reply = MessageBuilder()
                .plaintext(words.joinToString(" "))
                .build()
        )
    }
}