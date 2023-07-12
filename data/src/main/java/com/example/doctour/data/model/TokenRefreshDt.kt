package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.TokenRefresh
import com.google.gson.annotations.SerializedName

data class TokenRefreshDt(
    @SerializedName("token")
    val refresh: String,
    val access: String
) : DataMapper<TokenRefresh> {
    override fun mapToDomain() = TokenRefresh(
      refresh,
        access
    )

}
