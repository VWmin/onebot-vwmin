package com.vwmin.onebotvwmin.core.entities

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import java.lang.reflect.Type

class SegmentMessageDeserializer : JsonDeserializer<Message>{
    override fun deserialize(json: JsonElement?, t: Type?, context: JsonDeserializationContext?): Message {
        val jsonObject = json!!.asJsonObject
        val type = jsonObject["type"].asString
        val data :IData = when (type) {
            "text" -> context!!.deserialize(jsonObject["data"], SegmentText::class.java)
            "at" -> context!!.deserialize(jsonObject["data"], SegmentAt::class.java)
            else -> context!!.deserialize(jsonObject["data"], SegmentText::class.java)
        }

        return Message(type = type, data = data)
    }
}