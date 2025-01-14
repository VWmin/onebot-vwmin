package com.vwmin.onebotvwmin.core

import com.vwmin.onebotvwmin.core.entities.Message
import com.vwmin.onebotvwmin.core.entities.SegmentAt
import com.vwmin.onebotvwmin.core.entities.SegmentText

class MessageBuilder(
    private val message: MutableList<Message> = ArrayList()
) {
    fun plaintext(text: String): MessageBuilder {
        message.add(SegmentText.of(text))
        return this
    }

    fun at(id: Long): MessageBuilder {
        message.add(SegmentAt.of(id.toString()))
        return this
    }

    fun build(): List<Message> = message
}