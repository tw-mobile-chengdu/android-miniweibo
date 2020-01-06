package com.thoughtworks.miniweibo.util

import com.google.common.truth.Truth.assertThat

import org.junit.Test
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

class LocalDateTimeExtensionKtTest {

    @Test
    fun `should return minutes when less than one hour`() {
        val localDateTime = LocalDateTime.now().minus(30, ChronoUnit.MINUTES)

        assertThat(localDateTime.getShortFormat()).isEqualTo("30 分钟前")
    }

    @Test
    fun `should return at the moment when less than one minute`() {
        val lessThanOneHours = LocalDateTime.now().minus(30, ChronoUnit.SECONDS)

        assertThat(lessThanOneHours.getShortFormat()).isEqualTo("刚刚")
    }

    @Test
    fun `should return hours when time less than one day`() {
        val localDateTime = LocalDateTime.now().minus(10, ChronoUnit.HOURS)

        assertThat(localDateTime.getShortFormat()).isEqualTo("10 小时前")
    }

    @Test
    fun `should return yesterday when date time less than two day`() {
        val localDateTime = LocalDateTime.now().minus(26, ChronoUnit.HOURS)

        assertThat(localDateTime.getShortFormat()).isEqualTo("昨天")
    }

    @Test
    fun `should return the day before yesterday when date time less than three day`() {
        val localDateTime = LocalDateTime.now().minus(49, ChronoUnit.HOURS)

        assertThat(localDateTime.getShortFormat()).isEqualTo("前天")
    }

    @Test
    fun `should return the date info when date time more than three day`() {
        val localDateTime = LocalDateTime.now().minus(5, ChronoUnit.DAYS)

        assertThat(
            localDateTime.getShortFormat()
        ).isEqualTo(
            localDateTime.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日"))
        )
    }
}