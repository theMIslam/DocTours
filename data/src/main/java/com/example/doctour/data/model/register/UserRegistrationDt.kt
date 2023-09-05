package com.example.doctour.data.model.register

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.UserRegistration

data class UserRegistrationDt(
    val phone_number: String,
    val fullname: String,
    val gender: String,
    val birthday:String,
    val password: String
) : DataMapper<UserRegistration> {
    override fun mapToDomain() = UserRegistration(
       phone_number, fullname, gender, birthday, password
    )
}
fun UserRegistration.toUserRegisterDt() = UserRegistrationDt(
    phone_number, fullname, gender, birthday, password
)
