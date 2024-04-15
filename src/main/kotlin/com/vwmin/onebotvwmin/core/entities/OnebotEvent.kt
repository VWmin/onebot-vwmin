package com.vwmin.onebotvwmin.core.entities

interface OnebotEvent{
    val selfId: Long
    val time: Long
    val postType: String
}