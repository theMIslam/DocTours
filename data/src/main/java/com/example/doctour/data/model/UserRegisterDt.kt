package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.UserRegister

data class UserRegisterDt(
    val email: String?,
    val password: String?,
    val username: String?,
    val surname: String?,
    val lastname: String?,
    val phone: Int?,
    val gender: String?,
    val birthday: List<Int>?= emptyList()
) : DataMapper<UserRegister> {
    override fun mapToDomain() = UserRegister(
        email,
        password,
        username,
        surname,
        lastname,
        phone,
        gender,
        birthday
    )
}
