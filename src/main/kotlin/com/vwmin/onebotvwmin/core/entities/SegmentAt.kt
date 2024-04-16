package com.vwmin.onebotvwmin.core.entities

class SegmentAt(val qq : String) :IData {
    companion object{
        fun of(qq : String) : Message = Message(type = "at", data = SegmentAt(qq))
    }
}