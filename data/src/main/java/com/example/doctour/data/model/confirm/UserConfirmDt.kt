package com.example.doctour.data.model.confirm

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.confirm.UserConfirm
import com.google.gson.annotations.SerializedName

data class UserConfirmDt(
    @SerializedName("code")
    val code:Int?
):DataMapper<UserConfirm>{
    override fun mapToDomain()= UserConfirm(
        code
    )
}
fun UserConfirm.toUserConfirmDt()= UserConfirmDt(
    code
)
