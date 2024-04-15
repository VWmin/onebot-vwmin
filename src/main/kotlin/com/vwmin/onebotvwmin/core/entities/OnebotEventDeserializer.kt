package com.vwmin.onebotvwmin.core.entities

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonParseException
import java.lang.reflect.Type


class OnebotEventDeserializer : JsonDeserializer<OnebotEvent> {
    override fun deserialize(json: JsonElement?, typeOfT: Type?, context: JsonDeserializationContext?): OnebotEvent {
        val jsonObject = json!!.asJsonObject
        val postType = jsonObject["post_type"].asString

        val notEvent = JsonParseException("Json not a onebot event")
        val notSupportEvent = JsonParseException("Not supported post type: $postType")

        when (postType) {
            "message" -> return deserializeMessage(jsonObject, context)
            "notice" -> throw notSupportEvent
            "request" -> throw notSupportEvent
            "meta_event" -> throw notSupportEvent
            else -> throw notEvent
        }
    }

    private fun deserializeMessage(jsonObject: JsonObject, context: JsonDeserializationContext?): OnebotEvent {
        val messageType = jsonObject["message_type"].asString
        val notSupportMessage = JsonParseException("Not supported message type: $messageType")
        return when (messageType) {
            "private" -> context!!.deserialize(jsonObject, PrivateMessage::class.java)
            "group" -> context!!.deserialize(jsonObject, GroupMessage::class.java)
            else -> throw notSupportMessage
        }
    }

}