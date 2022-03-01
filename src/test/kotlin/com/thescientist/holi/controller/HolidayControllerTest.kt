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
import java.time.LocalDate

@SpringBootTest
@AutoConfigureMockMvc
internal class HolidayControllerTest @Autowired constructor (
    val mockMvc: MockMvc,
    val objectMapper: ObjectMapper
) {

    @Test
    internal fun `should return all holidays`() {
        mockMvc.get("/holidays")
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
}