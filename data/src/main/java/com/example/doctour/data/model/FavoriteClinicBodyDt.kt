package com.example.doctour.data.model

import com.example.doctour.domain.model.FavoriteClinicBody

data class FavoriteClinicBodyDt(
    val clinics:String
)

fun FavoriteClinicBody.toFavoriteClinicBodyDt()=FavoriteClinicBodyDt(
    clinics
)
