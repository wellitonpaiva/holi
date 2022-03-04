package com.thescientist.holi.model

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import java.time.LocalDate.of
import java.time.Month.JANUARY

internal class HolidayTest {

    val holiday = Holiday("Turin", of(2022, JANUARY, 1), of(2022, JANUARY, 10))

    @Test
    internal fun `true when start is within`() =
        assertTrue(holiday.isWithinRange(of(2022, JANUARY, 2)))

    @Test
    internal fun `true when date equals start`() =
        assertTrue(holiday.isWithinRange(of(2022, JANUARY, 1)))

    @Test
    internal fun `true when date equals end`() =
        assertTrue(holiday.isWithinRange(of(2022, JANUARY, 10)))

    @Test
    internal fun `true when date lower then end`() =
        assertTrue(holiday.isWithinRange(of(2022, JANUARY, 9)))

    @Test
    internal fun `false when start not within dates`() =
        assertFalse(holiday.isWithinRange(of(2021, JANUARY, 1)))

    @Test
    internal fun `false when end not within dates`() =
        assertFalse(holiday.isWithinRange(of(2023, JANUARY, 1)))
}