package com.example.doctour.data.remote.apiService.auth

import com.example.doctour.data.remote.dto.RefreshTokenDto
import com.example.doctour.data.remote.dto.TokensDto
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface RefreshAccessTokenApiService {

    @POST("users/refresh/")
    fun refreshTokens(@Body refreshToken: RefreshTokenDto): Call<TokensDto>
}