package com.example.doctour.data.model.tokenRefresh

import com.google.gson.annotations.SerializedName

data class SignInDto(
    @SerializedName("username")
    val username: String,
    @SerializedName("password")
    val password: String
)