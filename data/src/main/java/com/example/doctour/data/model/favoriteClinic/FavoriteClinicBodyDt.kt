package com.example.doctour.data.model.favoriteClinic

import com.example.doctour.domain.model.favoriteClinics.FavoriteClinicBody

data class FavoriteClinicBodyDt(
    val clinics:String
)

fun FavoriteClinicBody.toFavoriteClinicBodyDt()= FavoriteClinicBodyDt(
    clinics
)
