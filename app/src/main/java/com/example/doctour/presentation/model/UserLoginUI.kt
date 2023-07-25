package com.example.doctour.presentation.model

import com.example.doctour.domain.model.UserLogin


data class UserLoginUI(
    val phone_number: String,
    val password: String
)

fun UserLogin.toUserLoginUI()=UserLoginUI(
    phone_number, password
)
