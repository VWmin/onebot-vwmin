package com.vwmin.onebotvwmin.core

import com.google.gson.Gson
import com.vwmin.onebotvwmin.core.entities.OnebotEvent
import com.vwmin.onebotvwmin.core.entities.PrivateMessage
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import java.util.regex.Matcher
import java.util.regex.Pattern

@RestController
class PostController(val gson: Gson){

    @PostMapping("/onebot", consumes = ["application/json"])
    fun handleEvent(@RequestBody msgStr: String) {
        val event = gson.fromJson(msgStr, OnebotEvent::class.java)
        println(event.javaClass.simpleName)
    }


}

