package com.example.doctour.presentation.model.password

import com.example.doctour.domain.model.password.resetToken.PasswordResetToken

data class PasswordResetTokenUI(
    val code:String
)

fun PasswordResetToken.toPasswordResetTokenUI()= PasswordResetTokenUI(
    code
)
