package com.vwmin.onebotvwmin.core.entities

interface IOnebotEvent{
    val selfId: Long
    val time: Long
    val postType: String
}