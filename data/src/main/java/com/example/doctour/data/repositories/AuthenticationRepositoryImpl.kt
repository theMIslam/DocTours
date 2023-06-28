package com.example.doctour.data.repositories

import com.example.doctour.data.remote.apiservices.UserRegisterApiService
import com.example.doctour.data.remote.dtos.auth.SignInDto
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor(
    private val authenticationApiService: UserRegisterApiService
) {
     fun signIn(username: String, password: String) =
        authenticationApiService.login(SignInDto(username, password))
}