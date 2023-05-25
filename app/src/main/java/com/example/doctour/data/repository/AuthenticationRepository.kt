package com.example.doctour.data.repository

import com.example.doctour.data.base.BaseRepository
import com.example.doctour.data.remote.apiService.auth.AuthenticationApiService
import com.example.doctour.data.remote.dto.SignInDto
import com.example.doctour.data.remote.dto.SignInWithGoogleDto
import com.example.doctour.data.remote.dto.SignUpDto
import javax.inject.Inject

class AuthenticationRepository @Inject constructor(
    private val authenticationApiService: AuthenticationApiService
) : BaseRepository() {

    fun signUp(
        username: String,
        email: String,
        password: String,
        password_again: String
    ) = makeNetworkRequest {
        authenticationApiService.signUp(
            SignUpDto(
                username,
                email,
                password,
                password_again
            )
        )
    }

    fun signIn(username: String, password: String) = makeNetworkRequest {
        authenticationApiService.login(SignInDto(username, password))
    }

    fun signInWIthGoogle(idToken: String) = makeNetworkRequest {
        authenticationApiService.signInWithGoogle(SignInWithGoogleDto(idToken))
    }
}