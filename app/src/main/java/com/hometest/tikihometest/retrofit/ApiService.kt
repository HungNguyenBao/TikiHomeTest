package com.hometest.tikihometest.retrofit

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("talenguyen/38b790795722e7d7b1b5db051c5786e5/raw")
    fun getKeyWords(): Call<ArrayList<String>>
}