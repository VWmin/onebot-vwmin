package com.vwmin.onebotvwmin.core.entities

data class SegmentText(val text: String) :IData {
    companion object{
        fun of(text : String) : Message = Message(type = "text", data = SegmentText(text))
    }
}