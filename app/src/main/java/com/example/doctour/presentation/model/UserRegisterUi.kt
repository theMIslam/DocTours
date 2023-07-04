package com.example.doctour.presentation.model

import com.example.doctour.domain.model.UserRegister

data class UserRegisterUi(
    val phone_number: String?,
    val fullname: String?,
    val gender: String?,
    val birthday:String?,
    val password: String?
)

fun UserRegister.toUserRegisterUI() =UserRegisterUi(
    phone_number=phone_number,
    fullname=fullname,
    gender=gender,
    birthday=birthday,
    password=password
)
