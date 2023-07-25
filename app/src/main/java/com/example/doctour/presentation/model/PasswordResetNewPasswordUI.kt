package com.example.doctour.presentation.model

import com.example.doctour.domain.model.PasswordResetNewPassword

data class PasswordResetNewPasswordUI(
    val password:String
)

fun PasswordResetNewPassword.toPasswordResetNewPasswordUI()=PasswordResetNewPasswordUI(
    password
)

