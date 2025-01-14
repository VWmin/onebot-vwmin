package com.vwmin.onebotvwmin.core

import com.vwmin.onebotvwmin.core.entities.QuickReply

fun interface QuickOperation {
    fun reply() : QuickReply
}