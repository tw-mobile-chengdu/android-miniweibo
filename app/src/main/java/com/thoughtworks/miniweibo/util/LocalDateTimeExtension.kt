package com.thoughtworks.miniweibo.util

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

fun LocalDateTime.getShortFormat(): String {
    val duration = this.until(LocalDateTime.now(), ChronoUnit.SECONDS)

    if (duration > 60) {
        return "${duration / 60} 分钟前"
    } else {
        return "刚刚"
    }
}