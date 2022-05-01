package com.thescientist.holi.controller

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class StatusControllerTest {

    @Test
    fun startPage() {
        assertThat(StatusController().startPage()).isEqualTo("Welcome to Holi webservice")
    }
}