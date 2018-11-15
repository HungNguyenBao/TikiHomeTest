package com.hometest.tikihometest.retrofit

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

object Client {
    /********
     * URLS
     */
    var ROOT_URL: String = "https://gist.githubusercontent.com/"

    /**
     * Get Retrofit Instance
     */
    val retrofitInstance: Retrofit
        get() {
            val okHttpClient = OkHttpClient.Builder()
                .readTimeout(15, TimeUnit.SECONDS)
                .connectTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                .build()

            return Retrofit.Builder()
                .baseUrl(ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()
        }

    /**
     * Get API Service

     * @return API Service
     */
    val apiService: ApiService
        get() = retrofitInstance.create<ApiService>(ApiService::class.java)
}