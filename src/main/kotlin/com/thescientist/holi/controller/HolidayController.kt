package com.thescientist.holi.controller

import com.thescientist.holi.model.Holiday
import com.thescientist.holi.service.HolidayService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/holidays")
class HolidayController(private val service: HolidayService) {

    @GetMapping
    fun getHolidays(): Collection<Holiday> = service.retrieveHolidays()
}