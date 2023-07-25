package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.UserLogin
import com.google.gson.annotations.SerializedName

data class UserLoginDt(
    @SerializedName("phone_number")
    val phone_number: String,
    @SerializedName("password")
    val password: String
) : DataMapper<UserLogin> {
    override fun mapToDomain() = UserLogin(
        phone_number,
        password
    )
}
fun UserLogin.toUserLoginDt()=UserLoginDt(
    phone_number ,
    password
)
