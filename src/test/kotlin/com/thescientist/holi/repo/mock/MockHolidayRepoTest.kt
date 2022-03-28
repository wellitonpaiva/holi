package com.thescientist.holi.repo.mock

import com.thescientist.holi.model.Holiday
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.time.LocalDate.of
import java.time.Month
import java.time.Month.JUNE
import java.time.Month.SEPTEMBER

internal class MockHolidayRepoTest {

    @Test
    internal fun `should return list of holidays`() {
        val retrieveHolidays = MockHolidayRepo().retrieve()
        assertThat(retrieveHolidays).allMatch {
            it.name.isNotBlank()
            it.start.isBefore(it.end)
        }
    }

    @Test
    internal fun `should provide a single holiday when exists`() {
        val holidayName = "Paris"
        assertThat(MockHolidayRepo().retrieve(holidayName)).matches { it.name == holidayName }
    }

    @Test
    internal fun `should throw exception when holiday not found`() {
        assertThrows<NoSuchElementException> { MockHolidayRepo().retrieve("Tangamandapio") }
    }

    @Test
    internal fun `should add new holiday`() {
        val newHoliday = Holiday("Salamanca", of(2023, Month.AUGUST, 22), of(2023, SEPTEMBER, 23))
        val repo = MockHolidayRepo()
        repo.add(newHoliday)
        assertThat(repo.retrieve(newHoliday.name)).matches { it == newHoliday }
    }

    @Test
    internal fun `should throw exception when holiday already exists`() {
        val existingHoliday = Holiday("Paris", of(2021, JUNE, 3), of(2021, JUNE, 6))
        assertThrows<IllegalArgumentException> { MockHolidayRepo().add(existingHoliday) }
    }

    @Test
    internal fun `should throw exception when holiday start is within other holiday`() {
        val holiday = Holiday("Nice", of(2021, JUNE, 4), of(2021, JUNE, 16))
        assertThrows<IllegalArgumentException> { MockHolidayRepo().add(holiday) }
    }

    @Test
    internal fun `should throw exception when holiday end is within other holiday`() {
        val holiday = Holiday("Prague", of(2021, JUNE, 1), of(2021, JUNE, 3))
        assertThrows<IllegalArgumentException> { MockHolidayRepo().add(holiday) }
    }
}