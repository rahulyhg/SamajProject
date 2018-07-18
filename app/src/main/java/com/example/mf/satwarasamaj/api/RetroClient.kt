package com.example.mf.satwarasamaj.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetroClient {

    fun getRetroClient(): RetrofitApiService {
        val client = OkHttpClient().newBuilder().addInterceptor(getLoggingInterceptor()).build()
        val retrofit = Retrofit.Builder().baseUrl("https://raw.githubusercontent.com/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
        return retrofit.create(RetrofitApiService::class.java)
    }

    fun getLoggingInterceptor(): HttpLoggingInterceptor {
        val interceptor = HttpLoggingInterceptor()
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        return interceptor
    }
}