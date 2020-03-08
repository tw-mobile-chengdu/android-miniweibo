package com.thoughtworks.miniweibo.api

import com.google.gson.annotations.SerializedName

data class Post(
    val id: String,
    @field:SerializedName("created_at")
    val createdAt: String,
    @field:SerializedName("text")
    val text: String,
    val user: User,
    @field:SerializedName("pic_infos")
    var picInfos: HashMap<String, WeiboImage>
) {
    companion object {
        const val UNKNOWN_ID = -1
    }
}
