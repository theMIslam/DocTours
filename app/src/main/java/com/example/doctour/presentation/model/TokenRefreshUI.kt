package com.example.doctour.presentation.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.TokenRefresh

data class TokenRefreshUI(
    val refresh:String?,
    val access:String?
):DataMapper<TokenRefresh>{
    override fun mapToDomain()= TokenRefresh(
       refresh,access
    )
}

fun TokenRefresh.toTokenRefreshUI()=TokenRefreshUI(
    refresh,access
)
