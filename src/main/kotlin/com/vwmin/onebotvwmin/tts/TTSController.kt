package com.vwmin.onebotvwmin.tts

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.arguments.argument
import com.github.ajalt.clikt.parameters.arguments.multiple
import com.vwmin.onebotvwmin.core.CommandController
import com.vwmin.onebotvwmin.core.MessageBuilder
import com.vwmin.onebotvwmin.core.QuickOperation
import com.vwmin.onebotvwmin.core.entities.QuickReply

@CommandController(bind = "tts")
class TTSController : CliktCommand(), QuickOperation{

    val text: List<String> by argument(help = "text to convert").multiple(required = false)

    override fun run() {
        println("[TTSController] get $text")
    }

    override fun reply(): QuickReply {
        return QuickReply(
            reply = MessageBuilder()
                .plaintext("TODO")
                .build()
        )
    }

}