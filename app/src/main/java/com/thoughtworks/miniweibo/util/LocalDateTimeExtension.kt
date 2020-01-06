package com.thoughtworks.miniweibo.util

import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

fun LocalDateTime.getShortFormat(): String {
    val duration = this.until(LocalDateTime.now(), ChronoUnit.SECONDS)
    when {
        duration > DurationConstants.THREE_DAYS_BEFORE -> {
            return this.format(DateTimeFormatter.ofPattern("yyyy年MM月dd日"))
        }
        duration > DurationConstants.THE_DAY_BEFORE_YESTERDAY -> {
            return "前天"
        }
        duration > DurationConstants.YESTERDAY -> {
            return "昨天"
        }
        duration > DurationConstants.ONE_HOURS -> {
            return "${duration / 60 / 60} 小时前"
        }
        duration > DurationConstants.ONE_MINUTES -> {
            return "${duration / 60} 分钟前"
        }
        else -> {
            return "刚刚"
        }
    }
}

object DurationConstants {
    const val THREE_DAYS_BEFORE = 60 * 60 * 24 * 3
    const val THE_DAY_BEFORE_YESTERDAY = 60 * 60 * 24 * 2
    const val YESTERDAY = 60 * 60 * 24
    const val ONE_HOURS = 60 * 60
    const val ONE_MINUTES = 60
}