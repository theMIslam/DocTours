package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.password.resetNew.PasswordResetNewPassword

data class PasswordResetNewPasswordDt(
    val password: String
) : DataMapper<PasswordResetNewPassword> {
    override fun mapToDomain() = PasswordResetNewPassword(
        password
    )
}

fun PasswordResetNewPassword.toPasswordResetNewPasswordDt()=PasswordResetNewPasswordDt(
    password
)
