package com.thoughtworks.miniweibo.util

import org.junit.Assert.assertEquals
import org.junit.Test
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

class LocalDateTimeExtensionKtTest {

    @Test
    fun `should return minutes when less than one hour`() {
        val localDateTime = LocalDateTime.now().minus(30, ChronoUnit.MINUTES)

        assertEquals("30 分钟前", localDateTime.getShortFormat())
    }

    @Test
    fun `should return at the moment when less than one minute`() {
        val lessThanOneHours = LocalDateTime.now().minus(30, ChronoUnit.SECONDS)

        assertEquals("刚刚", lessThanOneHours.getShortFormat())
    }

    @Test
    fun `should return hours when date time less than one day`() {
        val localDateTime = LocalDateTime.now().minus(10, ChronoUnit.HOURS)

        assertEquals("10 小时前", localDateTime.getShortFormat())
    }

    @Test
    fun `should return yesterday when date time less than two day`() {
        val localDateTime = LocalDateTime.now().minus(26, ChronoUnit.HOURS)

        assertEquals("昨天", localDateTime.getShortFormat())
    }

    @Test
    fun `should return the day before yesterday when date time less than three day`() {
        val localDateTime = LocalDateTime.now().minus(49, ChronoUnit.HOURS)

        assertEquals("前天", localDateTime.getShortFormat())
    }

    @Test
    fun `should return the date info when date time more than three day`() {
        val localDateTime = LocalDateTime.now().minus(5, ChronoUnit.DAYS)

        assertEquals(localDateTime.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日")), localDateTime.getShortFormat())
    }
}