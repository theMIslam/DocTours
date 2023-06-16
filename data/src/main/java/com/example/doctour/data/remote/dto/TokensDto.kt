package com.example.doctour.data.remote.dto


data class TokensDto(
    @SerializedName("refresh")
    val refresh: String,
    @SerializedName("access")
    val access: String
)