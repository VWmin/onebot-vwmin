package com.vwmin.onebotvwmin.core

import com.vwmin.onebotvwmin.core.entities.QuickReply

interface QuickOperation {
    fun reply() : QuickReply
}