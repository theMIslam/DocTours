package com.example.doctour.presentation.model.password

import com.example.doctour.domain.model.password.resetNew.PasswordResetNewPassword

data class PasswordResetNewPasswordUI(
    val password: String
)

fun PasswordResetNewPassword.toPasswordResetNewPasswordUI() = PasswordResetNewPasswordUI(
    password
)

