package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.UserRegister

data class UserRegisterDt(
    val phone_number: String?,
    val fullname: String?,
    val gender: String?,
    val birthday:String?,
    val password: String?
) : DataMapper<UserRegister> {
    override fun mapToDomain() = UserRegister(
       phone_number, fullname, gender, birthday, password
    )
}
