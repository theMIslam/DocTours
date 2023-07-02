package com.example.doctour.data.remote.apiservices

import com.example.doctour.data.remote.dtos.auth.SignInDto
import com.example.doctour.data.remote.dtos.auth.SignInResultDto
import com.example.doctour.data.remote.dtos.auth.SignUpDto
import com.example.doctour.data.remote.dtos.tokens.RefreshToken
import com.example.doctour.data.remote.dtos.tokens.Tokens
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthenticatorApiService {

    @POST("/api/refreshtoken")
    fun refreshToken(@Body refreshToken: RefreshToken): Call<Tokens>

    @POST("users/register/")
    suspend fun signUp(@Body signUpDto: SignUpDto)

    @POST("users/login/")
    suspend fun login(@Body signInDto: SignInDto): SignInResultDto
}