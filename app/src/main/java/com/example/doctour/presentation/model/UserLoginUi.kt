package com.example.doctour.presentation.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.UserLogin

data class UserLoginUi(
    val phone_number: String?,
    val password: String?
):DataMapper<UserLogin>{
    override fun mapToDomain()= UserLogin(
        phone_number, password
    )
}

fun UserLogin.toUserLoginUi()=UserLogin(
    phone_number, password
)