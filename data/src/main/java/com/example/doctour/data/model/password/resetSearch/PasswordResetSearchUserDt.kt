package com.example.doctour.data.model.password.resetSearch

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.password.resetSearch.PasswordResetSearchUser

data class PasswordResetSearchUserDt(
    val phone_number: String
) : DataMapper<PasswordResetSearchUser> {
    override fun mapToDomain() = PasswordResetSearchUser(
        phone_number
    )
}

fun PasswordResetSearchUser.toPasswordResetSearchUserDt()= PasswordResetSearchUserDt(
    phone_number
)
