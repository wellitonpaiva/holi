package com.thescientist.holi.repo

import com.thescientist.holi.model.Holiday

interface HolidayRepo {

    fun retrieveHolidays(): Collection<Holiday>
    fun retrieveHoliday(holidayName: String): Holiday
}