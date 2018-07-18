package com.example.mf.satwarasamaj.api

import com.example.mf.satwarasamaj.model.City
import retrofit2.Call
import retrofit2.http.GET

interface RetrofitApiService {

    @GET("nshntarora/Indian-Cities-JSON/master/cities.json")
    fun doGetCitiesApiCall(): Call<List<City>>
}