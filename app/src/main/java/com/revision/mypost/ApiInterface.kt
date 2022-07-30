package com.revision.mypost

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiInterface {
    @GET("/posts")
    fun getposts():Call<List<Post>>

    @GET("/post/{id}")
    fun getPostById(@Path("id") postId : Int) :Call <List<Post>>
}