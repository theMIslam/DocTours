package com.example.doctour.presentation.model.confirm

import com.example.doctour.domain.model.confirm.UserConfirm

data class UserConfirmUI(
    val code: Int?
)

fun UserConfirm.toUserConfirmUI() = UserConfirmUI(
    code
)
