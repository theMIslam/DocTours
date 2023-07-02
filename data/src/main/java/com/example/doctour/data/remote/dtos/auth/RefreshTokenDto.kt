package com.example.doctour.data.remote.dtos.auth

import com.google.gson.annotations.SerializedName

data class RefreshTokenDto(
    @SerializedName("refresh")
    val refresh: String
)