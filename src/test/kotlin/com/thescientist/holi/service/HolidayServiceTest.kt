package com.thescientist.holi.service

import com.thescientist.holi.repo.HolidayRepo
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test

internal class HolidayServiceTest{

    private val repo: HolidayRepo = mockk(relaxed = true)

    private val service = HolidayService(repo)

    @Test
    internal fun `should call its repo to retrieve holidays`() {
        service.retrieveHolidays()
        verify(exactly = 1) { repo.retrieveHolidays() }
    }

    @Test
    internal fun `should call its repo to retrieve holiday`() {
        val holidayName = "Paris"
        service.retrieveHoliday(holidayName)
        verify(exactly = 1) { repo.retrieveHoliday(holidayName) }
    }
}