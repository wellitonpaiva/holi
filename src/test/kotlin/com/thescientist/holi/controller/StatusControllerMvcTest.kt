package com.thescientist.holi.controller

import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.http.HttpStatus
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.get

@WebMvcTest(StatusController::class)
internal class StatusControllerMvcTest @Autowired constructor(private val mockMvc: MockMvc) {

    @Test
    internal fun `should show welcome message`() {
        mockMvc.get("/")
            .andExpect {
                status { HttpStatus.OK }
                content { string("Welcome to Holi webservice") }
            }
    }
}