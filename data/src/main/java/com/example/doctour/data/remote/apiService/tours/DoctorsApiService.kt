package com.example.doctour.data.remote.apiService.tours

import com.example.doctour.presentation.ui.fragments.main.model.BermetFeedback
import com.example.doctour.presentation.ui.fragments.main.model.BermetModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DoctorsApiService {

    @GET("home/slugs")
    suspend fun getSlugs(): Response<BermetFeedback>

    @GET("home/tour/{slug}")
    suspend fun getTourBySlug(
        @Path("slug") slug: String,
    ): Response<BermetModel>

    @GET("home/tours/")
    suspend fun getTours(
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int,
    ): Response<BermetFeedback>
}