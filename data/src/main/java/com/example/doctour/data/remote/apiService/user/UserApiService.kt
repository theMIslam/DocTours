package com.example.doctour.data.remote.apiService.user

import com.example.doctour.data.remote.dto.favourites.FavoriteDoctourResponse
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApiService {

    @GET("profiles/{id}/favorites")
    suspend fun fetchFavorites(@Path("id") id: Int): FavoriteDoctourResponse

    @DELETE("profiles/profile/{id}/")
    suspend fun deleteAccount(@Path("id") id: Int)
}