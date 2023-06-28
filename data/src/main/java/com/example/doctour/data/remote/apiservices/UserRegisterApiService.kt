package com.example.doctour.data.remote.apiservices

import com.example.doctour.data.remote.dtos.auth.SignInDto
import com.example.doctour.data.remote.dtos.auth.SignInResultDto
import com.example.doctour.data.remote.dtos.auth.UserRegisterDto
import com.example.doctour.domain.model.UserRegister
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserRegisterApiService {

    @POST("/api/register")
    fun usersRegister(@Body usersRegister: UserRegisterDto): Call<UserRegister>

    @POST("users/login/")
    fun login(@Body signInDto: SignInDto): SignInResultDto
}