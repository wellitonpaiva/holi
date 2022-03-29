package com.thescientist.holi.controller

import com.thescientist.holi.service.HolidayService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class StatusController(private val service: HolidayService) {

    @GetMapping
    fun startPage() = "Welcome to Holi webservice"
}