package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.PasswordConfirmReset

data class PasswordConfirmResetDt(
    val password:String?
):DataMapper<PasswordConfirmReset>{
    override fun mapToDomain()=PasswordConfirmReset(
        password
    )
}
