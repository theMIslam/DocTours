package com.example.doctour.data.model

import com.example.doctour.domain.model.TokenRefreshBody

data class TokenRefreshBodyDt(
    val refresh:String
)

fun TokenRefreshBody.toTokenRefreshBodyDt()=TokenRefreshBodyDt(
    refresh
)
