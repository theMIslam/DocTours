package com.example.doctour.data.remote.dto

import com.google.gson.annotations.SerializedName

data class SignInWithGoogleDto(
    @SerializedName("access_token")
    val idToken: String
)