package com.thoughtworks.miniweibo.api

import com.google.gson.annotations.SerializedName

data class User(
    val id: String,
    @field:SerializedName("screen_name")
    val screenName: String,
    val name: String,
    @field:SerializedName("profile_image_url")
    val profileImageUrl: String
)