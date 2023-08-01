package com.example.doctour.presentation.model

import com.example.doctour.domain.model.UserConfirm

data class UserConfirmUI(
    val code:Int?
)

fun UserConfirm.toUserConfirmUI()=UserConfirmUI(
    code
)
