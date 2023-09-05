package com.example.doctour.presentation.model.login

import com.example.doctour.domain.model.UserLogin


data class UserLoginUI(
    val phone_number: String,
    val password: String
)

fun UserLogin.toUserLoginUI() = UserLoginUI(
    phone_number, password
)
