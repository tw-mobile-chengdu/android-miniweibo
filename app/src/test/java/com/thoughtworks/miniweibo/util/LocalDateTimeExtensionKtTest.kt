package com.thoughtworks.miniweibo.util

import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class LocalDateTimeExtensionKtTest {

    @Test
    fun `should return minutes when less than one hour`() {
        val lessThanOneHours = LocalDateTime.now().minus(30, ChronoUnit.MINUTES)

        assertEquals("30 分钟前", lessThanOneHours.getShortFormat())
    }

    @Test
    fun `should return at the moment when less than one minute`() {
        val lessThanOneHours = LocalDateTime.now().minus(30, ChronoUnit.SECONDS)

        assertEquals("刚刚", lessThanOneHours.getShortFormat())
    }
}