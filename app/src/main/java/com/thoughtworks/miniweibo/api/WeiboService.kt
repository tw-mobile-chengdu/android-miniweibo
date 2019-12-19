package com.thoughtworks.miniweibo.api

import androidx.lifecycle.LiveData
import retrofit2.http.GET

interface WeiboService {
    @GET("home-timeline")
    fun getPosts(): LiveData<ApiResponse<List<Post>>>
}
