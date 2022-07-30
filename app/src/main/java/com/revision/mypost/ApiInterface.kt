package com.revision.mypost

import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {
    @GET("/post")
    fun getposts():Call<List<Post>>
}