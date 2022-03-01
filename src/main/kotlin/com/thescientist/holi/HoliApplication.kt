package com.thescientist.holi

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class HoliApplication

fun main(args: Array<String>) {
	runApplication<HoliApplication>(*args)
}
