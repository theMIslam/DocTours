package com.example.doctour.data.remote.apiservices

import com.example.doctour.domain.model.UserRegister
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserRegisterApiService {

    @POST("/api/register")
    fun usersRegister(@Body usersRegister: UserRegister): Call<UserRegister>
}