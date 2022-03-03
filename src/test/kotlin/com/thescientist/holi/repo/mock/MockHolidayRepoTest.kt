package com.thescientist.holi.repo.mock

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

internal class MockHolidayRepoTest {

    @Test
    internal fun `should return list of holidays`() {
        val retrieveHolidays = MockHolidayRepo().retrieveHolidays()
        assertThat(retrieveHolidays).allMatch {
            it.name.isNotBlank()
            it.start.isBefore(it.end)
        }
    }

    @Test
    internal fun `should provide a single holiday when exists`() {
        val holidayName = "Paris"
        assertThat(MockHolidayRepo().retrieveHoliday(holidayName)).matches { it.name == holidayName }
    }

    @Test
    internal fun `should throw exception when holiday not found`() {
        assertThrows<NoSuchElementException> { MockHolidayRepo().retrieveHoliday("Tangamandapio") }
    }
}