package com.vwmin.onebotvwmin.core

import org.springframework.stereotype.Component

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@MustBeDocumented
@Component
annotation class CommandController(val bind: String, val alias: Array<String> = [])
