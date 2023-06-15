package com.example.doctour.data.remote.apiservices

import com.example.doctour.data.remote.dtos.tokens.RefreshToken
import com.example.doctour.data.remote.dtos.tokens.Tokens
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticatorApiService {

    @POST("/api/refreshtoken")
    fun refreshToken(@Body refreshToken: RefreshToken): Call<Tokens>
}
