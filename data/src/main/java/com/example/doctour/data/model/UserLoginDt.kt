package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.UserLogin

data class UserLoginDt(
    val email: String?,
    val password: String?
) : DataMapper<UserLogin> {
    override fun mapToDomain() = UserLogin(
        email,
        password
    )
}
