package com.vwmin.onebotvwmin.core.entities

interface IOnebotMessage {
    fun rawMessage(): String
    fun segmentMessages(): List<Message>
}