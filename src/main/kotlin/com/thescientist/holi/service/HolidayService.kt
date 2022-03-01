package com.thescientist.holi.service

import com.thescientist.holi.model.Holiday
import com.thescientist.holi.repo.HolidayRepo
import org.springframework.stereotype.Service

@Service
class HolidayService(private val repo: HolidayRepo) {

    fun retrieveHolidays(): Collection<Holiday> = repo.retrieveHolidays()
}