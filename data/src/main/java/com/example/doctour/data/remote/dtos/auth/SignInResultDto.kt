package com.example.doctour.data.remote.dtos.auth

    data class SignInResultDto(
        val id: String,
        val tokens: String,
        val username: String
    )
