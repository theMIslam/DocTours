package com.example.doctour.data.remote.apiservices

import com.example.doctour.data.remote.dtos.doctour.DoctourDto
import com.example.doctour.data.remote.dtos.doctour.DoctourPagingResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface DoctourApiService {

    @GET("/api/foo")
    suspend fun fetchDoctour(): Response<DoctourDto>

    @GET("/api/foo")
    suspend fun fetchDoctourPaging(
        @Query("page") page: Int
    ): Response<DoctourPagingResponse<DoctourDto>>
}