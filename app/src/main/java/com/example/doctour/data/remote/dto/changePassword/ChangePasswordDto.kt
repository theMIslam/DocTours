package com.example.doctour.data.remote.dto.changePassword

import com.google.gson.annotations.SerializedName

data class ChangePasswordDto(
    @SerializedName("email")
    val email: String,
    @SerializedName("password_old")
    val password_old: String,
    @SerializedName("password_new")
    val password_new: String,
    @SerializedName("password_new_again")
    val password_new_again: String,
)