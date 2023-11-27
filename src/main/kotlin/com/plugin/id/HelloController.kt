package com.plugin.id

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class HelloController {
    @GetMapping("/greeting")
    fun sayHello() ="Hello World !!!";
}