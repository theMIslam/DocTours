package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.password.resetToken.PasswordResetToken

data class PasswordResetTokenDt(
    val code:String
):DataMapper<PasswordResetToken>{
    override fun mapToDomain()= PasswordResetToken(
        code
    )
}

fun PasswordResetToken.toPasswordResetTokenDt()=PasswordResetTokenDt(
    code
)
