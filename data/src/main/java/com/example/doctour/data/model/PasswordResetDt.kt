package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.PasswordReset

data class PasswordResetDt(
    val email: String
) : DataMapper<PasswordReset> {
    override fun mapToDomain() = PasswordReset(
        email
    )
}
