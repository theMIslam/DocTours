package com.example.doctour.domain.model

data class UserRegistration(
    val phone_number: String,
    val fullname: String,
    val gender: String,
    val birthday:String,
    val password: String
)
