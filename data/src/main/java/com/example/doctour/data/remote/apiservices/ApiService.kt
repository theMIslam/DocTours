package com.example.doctour.data.remote.apiservices

import com.example.doctour.data.model.HomeModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET
    fun getData(): Call<List<HomeModel>>
}