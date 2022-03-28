package com.thescientist.holi.controller

import com.thescientist.holi.model.Holiday
import com.thescientist.holi.service.HolidayService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/holidays")
class HolidayController(private val service: HolidayService) {

    @ExceptionHandler(NoSuchElementException::class)
    fun handleNotFound(e: NoSuchElementException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.NOT_FOUND)

    @ExceptionHandler(IllegalArgumentException::class)
    fun handleBadRequest(e: IllegalArgumentException): ResponseEntity<String> =
        ResponseEntity(e.message, HttpStatus.BAD_REQUEST)

    @GetMapping
    fun getHolidays(): Collection<Holiday> = service.retrieveHolidays()

    @GetMapping
    @RequestMapping("/{holidayName}")
    fun getHoliday(@PathVariable holidayName: String): Holiday = service.retrieveHoliday(holidayName)

    @PostMapping
    fun addHoliday(@RequestBody holiday: Holiday): Holiday = service.addHoliday(holiday)

    @PatchMapping
    fun editHoliday(@RequestBody holiday: Holiday): Holiday = service.editHoliday(holiday)
}