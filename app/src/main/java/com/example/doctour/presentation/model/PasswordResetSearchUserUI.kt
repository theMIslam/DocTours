package com.example.doctour.presentation.model

import com.example.doctour.domain.model.PasswordResetSearchUser

data class PasswordResetSearchUserUI(
    val phone_number:String
)

fun PasswordResetSearchUser.toPasswordResetSearchUserUI()=PasswordResetSearchUserUI(
    phone_number
)
