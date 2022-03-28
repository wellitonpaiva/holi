package com.thescientist.holi.service

import com.thescientist.holi.model.Holiday
import com.thescientist.holi.repo.HolidayRepo
import org.springframework.stereotype.Service

@Service
class HolidayService(private val repo: HolidayRepo) {

    fun retrieveHolidays(): Collection<Holiday> = repo.retrieve()
    fun retrieveHoliday(holidayName: String): Holiday = repo.retrieve(holidayName)
    fun addHoliday(holiday: Holiday): Holiday = repo.add(holiday)
    fun editHoliday(holiday: Holiday): Holiday = repo.edit(holiday)
}