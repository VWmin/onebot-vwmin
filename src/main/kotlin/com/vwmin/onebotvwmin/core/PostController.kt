package com.vwmin.onebotvwmin.core

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.core.CliktError
import com.vwmin.onebotvwmin.core.entities.*
import jakarta.annotation.PostConstruct
import org.springframework.context.ApplicationContext
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PostController(
    private val context: ApplicationContext,
    private val appConfig: AppConfig,
) {
    val commandCache = HashMap<String, QuickOperation>()

    @PostConstruct
    fun initCommandHandlerBinds() {
        val beansWithAnnotation = context.getBeansWithAnnotation(CommandController::class.java)
        beansWithAnnotation.forEach { (_, bean) ->
            val annotation = bean.javaClass.getAnnotation(CommandController::class.java)
            val bind = annotation.bind
            if (commandCache.containsKey(bind)) {
                println("conflicting command $bind to ${commandCache[bind]!!.javaClass.getSimpleName()}")
            }
            commandCache[bind] = bean as QuickOperation
        }
    }

    @PostMapping("/onebot", consumes = ["application/json"])
    fun handleEvent(@RequestBody event: IOnebotEvent): IQuickReply {
        if (event is IOnebotMessage) {
            val messages = event.segmentMessages()
            var command = ""
            val args = ArrayList<String>()

            // 特殊处理
            for (message in messages) {
                when (message.type) {
                    "at" -> if ((message.data as SegmentAt).qq == appConfig.selfId.toString()) {
                        command = "chat"
                    }

                    "text" -> if (command == "") {
                        val text = (message.data as SegmentText).text
                        val words = text.split("\\s+".toRegex()).filter { it.isNotEmpty() }
                        if (words.size > 1) {
                            command = words[0]
                            args.addAll(words.drop(1))
                        }
                    } else {
                        args.add((message.data as SegmentText).text)
                    }
                }
            }
            println("command: $command, args: ${args.joinToString(" ")}")

            val operation = commandCache[command] ?: return EmptyReply()

            operation as CliktCommand
            try {
                operation.parse(args)
                return operation.reply()
            } catch (e: CliktError) {
                operation.echoFormattedHelp(e)
                return EmptyReply()
            }
        }
        return EmptyReply()
    }
}
