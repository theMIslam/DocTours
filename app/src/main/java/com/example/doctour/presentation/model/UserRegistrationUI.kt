package com.example.doctour.presentation.model

import com.example.doctour.domain.model.UserRegistration

data class UserRegistrationUI(
    val phone_number: String,
    val fullname: String,
    val gender: String,
    val birthday:String,
    val password: String
)

fun UserRegistration.toUserRegistrationUI()=UserRegistrationUI(
    phone_number, fullname, gender, birthday, password
)