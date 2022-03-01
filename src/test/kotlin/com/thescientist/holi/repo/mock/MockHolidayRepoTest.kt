package com.thescientist.holi.repo.mock

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class MockHolidayRepoTest {

    @Test
    internal fun `should return list of holidays`() {
        val retrieveHolidays = MockHolidayRepo().retrieveHolidays()
        assertThat(retrieveHolidays).allMatch {
            it.name.isNotBlank()
            it.start.isBefore(it.end)
        }
    }
}