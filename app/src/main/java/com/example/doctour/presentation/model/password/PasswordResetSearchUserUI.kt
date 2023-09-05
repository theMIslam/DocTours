package com.example.doctour.presentation.model.password

import com.example.doctour.domain.model.password.resetSearch.PasswordResetSearchUser

data class PasswordResetSearchUserUI(
    val phone_number:String
)

fun PasswordResetSearchUser.toPasswordResetSearchUserUI()= PasswordResetSearchUserUI(
    phone_number
)
