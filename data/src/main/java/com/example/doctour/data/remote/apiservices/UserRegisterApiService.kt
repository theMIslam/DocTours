package com.example.doctour.data.remote.apiservices

import androidx.room.ProvidedTypeConverter
import com.example.doctour.data.remote.dtos.auth.SignInDto
import com.example.doctour.data.remote.dtos.auth.SignInResultDto
import com.example.doctour.data.remote.dtos.auth.SignUpDto
import com.example.doctour.data.remote.dtos.auth.UserRegisterDto
import com.example.doctour.domain.model.UserRegister
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

@ProvidedTypeConverter
interface UserRegisterApiService {

//    @POST("/api/v1/register")
//    fun usersRegister(@Body usersRegister: UserRegisterDto): Call<UserRegister>

    @POST("api/v1/users/login/")
    suspend fun login(@Body signInDto: SignInDto): SignInResultDto


    @POST("api/v1/users/register/")
    fun signUp(signUpDto: SignUpDto)
}