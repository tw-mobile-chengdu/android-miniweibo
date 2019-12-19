package com.thoughtworks.miniweibo.api

import com.google.gson.annotations.SerializedName

data class Post(
    val id: String,
    @field:SerializedName("text")
    val text: String
) {
    companion object {
        const val UNKNOWN_ID = -1
    }
}
