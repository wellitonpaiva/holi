package com.thescientist.holi.repo.mock

import com.thescientist.holi.model.Holiday
import com.thescientist.holi.repo.HolidayRepo
import org.springframework.stereotype.Repository
import java.time.LocalDate.of
import java.time.Month.*

@Repository
class MockHolidayRepo: HolidayRepo {

    val holidays = listOf(
        Holiday("Paris", of(2021, JUNE, 3), of(2021, JUNE, 6)),
        Holiday("Barcelona", of(2021, JULY, 28), of(2021, AUGUST, 6))
    )

    override fun retrieveHolidays(): Collection<Holiday> {
        return holidays
    }

}