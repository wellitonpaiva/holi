package com.thescientist.holi.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class StatusController {

    @GetMapping
    fun startPage() = "Welcome to Holi webservice"
}