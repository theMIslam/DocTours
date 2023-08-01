package com.example.doctour.presentation.model

import com.example.doctour.domain.model.PasswordResetToken

data class PasswordResetTokenUI(
    val code:String
)

fun PasswordResetToken.toPasswordResetTokenUI()=PasswordResetTokenUI(
    code
)
