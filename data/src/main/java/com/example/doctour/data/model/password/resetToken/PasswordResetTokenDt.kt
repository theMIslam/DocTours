package com.example.doctour.data.model.password.resetToken

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.password.resetToken.PasswordResetToken

data class PasswordResetTokenDt(
    val code:String
):DataMapper<PasswordResetToken>{
    override fun mapToDomain()= PasswordResetToken(
        code
    )
}

fun PasswordResetToken.toPasswordResetTokenDt()= PasswordResetTokenDt(
    code
)
