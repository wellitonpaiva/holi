package com.thescientist.holi.controller

import com.fasterxml.jackson.databind.ObjectMapper
import com.thescientist.holi.model.Holiday
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get
import org.springframework.test.web.servlet.post
import java.time.LocalDate
import java.time.LocalDate.of
import java.time.Month
import java.time.Month.*

@SpringBootTest
@AutoConfigureMockMvc
internal class HolidayControllerTest @Autowired constructor (
    val mockMvc: MockMvc,
    val objectMapper: ObjectMapper
) {

    val baseUrl = "/holidays"

    @Test
    internal fun `should return all holidays`() {
        mockMvc.get(baseUrl)
            .andDo { print() }
            .andExpect {
                status { isOk() }
                content {
                    contentType(MediaType.APPLICATION_JSON)
                    jsonPath("$[0].name") { value("Paris") }
                    jsonPath("$[1].name") { value("Barcelona") }
                }
            }
    }

    @Test
    internal fun `should return single holiday`() {
        val holiday = "Paris"

        mockMvc.get("$baseUrl/$holiday")
            .andDo { print() }
            .andExpect {
                status { isOk() }
                content {
                    contentType(MediaType.APPLICATION_JSON)
                    json(objectMapper.writeValueAsString(
                        Holiday("Paris", of(2021, JUNE, 3), of(2021, JUNE, 6))
                    ))
                }
            }
    }

    @Test
    internal fun `should throw error when holiday not found`() {
        val holidayName = "Acapulco"
        mockMvc.get("$baseUrl/$holidayName")
            .andDo { print() }
            .andExpect { status { isNotFound() } }
    }

    @Test
    internal fun `should add new holiday`() {
        val newHoliday = Holiday("Lisbon", of(2023, JUNE, 1), of(2023, JUNE, 4))
        val newHolidayAsJson = objectMapper.writeValueAsString(newHoliday)
        mockMvc.post(baseUrl) {
            contentType = MediaType.APPLICATION_JSON
            content = newHolidayAsJson
        }
            .andDo { print() }
            .andExpect { content {
                contentType(MediaType.APPLICATION_JSON)
                json(newHolidayAsJson)
            } }
    }

    @Test
    internal fun `should throw error when holiday exists`() {
        val existingHolidayAsJson = objectMapper.writeValueAsString(
            Holiday("Paris", of(2021, JUNE, 3), of(2021, JUNE, 6)))
        mockMvc.post(baseUrl) {
            contentType = MediaType.APPLICATION_JSON
            content = existingHolidayAsJson
        }
            .andDo { print() }
            .andExpect { status { isBadRequest() } }
    }
}