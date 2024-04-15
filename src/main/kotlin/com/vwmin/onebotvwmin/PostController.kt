package com.vwmin.onebotvwmin

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PostController

@PostMapping("/onebot")
fun handleEvent(){

}

@GetMapping("/test")
fun test() :String {
    println("test")
    return "Test"
}