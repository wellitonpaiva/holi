package com.thescientist.holi.model

import java.time.LocalDate

data class Holiday(val name: String, val start: LocalDate, val end: LocalDate) {

    fun isWithinRange(date: LocalDate): Boolean = (date.isEqual(start) || date.isEqual(end))
            || (date.isBefore(end) && date.isAfter(start))
}
