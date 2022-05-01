package com.thescientist.holi.controller

import com.thescientist.holi.model.Holiday
import com.thescientist.holi.service.HolidayService
import io.mockk.every
import io.mockk.mockk
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.time.LocalDate

internal class HolidayControllerTest {

    @Test
    internal fun `should return all holidays`() {
        val service = mockk<HolidayService>()
        val holidays = listOf(Holiday("name", LocalDate.now(), LocalDate.now()))
        every { service.retrieveHolidays() } returns holidays
        Assertions.assertThat(HolidayController(service).getHolidays()).isEqualTo(holidays)
    }
}