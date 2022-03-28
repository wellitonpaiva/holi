package com.thescientist.holi.repo.mock

import com.thescientist.holi.model.Holiday
import com.thescientist.holi.repo.HolidayRepo
import org.springframework.stereotype.Repository
import java.time.LocalDate.of
import java.time.Month.*

@Repository
class MockHolidayRepo: HolidayRepo {

    val holidays = mutableListOf(
        Holiday("Paris", of(2021, JUNE, 3), of(2021, JUNE, 6)),
        Holiday("Barcelona", of(2021, JULY, 28), of(2021, AUGUST, 6))
    )

    override fun retrieve(): Collection<Holiday>  = holidays

    override fun retrieve(holidayName: String): Holiday =
        holidays.firstOrNull { it.name == holidayName }
            ?: throw NoSuchElementException("Could not find Holiday with name: $holidayName")

    override fun add(holiday: Holiday): Holiday {
        if(holidays.any { it.isWithinRange(holiday.start) || it.isWithinRange(holiday.end) }) {
            throw IllegalArgumentException("Holiday dates already have other travel booked for the same dates")
        }
        holidays.add(holiday)
        return holiday
    }

    override fun edit(holiday: Holiday): Holiday {
        retrieve(holiday.name)
        if(holidays.any { it.name != holiday.name && (it.isWithinRange(holiday.start) || it.isWithinRange(holiday.end)) }) {
            throw IllegalArgumentException("Holiday dates already have other travel booked for the same dates")
        }
        remove(holiday.name)
        add(holiday)
        return holiday
    }

    override fun remove(holidayName: String) {
        holidays.remove(retrieve(holidayName))
    }
}