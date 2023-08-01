package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.UserConfirm
import com.google.gson.annotations.SerializedName

data class UserConfirmDt(
    @SerializedName("code")
    val code:Int?
):DataMapper<UserConfirm>{
    override fun mapToDomain()=UserConfirm(
        code
    )
}
fun UserConfirm.toUserConfirmDt()=UserConfirmDt(
    code
)
