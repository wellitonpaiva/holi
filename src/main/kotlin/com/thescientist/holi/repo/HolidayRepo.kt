package com.thescientist.holi.repo

import com.thescientist.holi.model.Holiday

interface HolidayRepo {

    fun retrieve(): Collection<Holiday>
    fun retrieve(holidayName: String): Holiday
    fun add(holiday: Holiday): Holiday
    fun edit(holiday: Holiday): Holiday
    fun remove(holidayName: String)
}