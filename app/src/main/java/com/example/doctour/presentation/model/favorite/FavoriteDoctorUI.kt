package com.example.doctour.presentation.model.favorite

import com.example.doctour.base.IBaseDiffModel
import com.example.doctour.domain.model.favoriteDoctors.FavoriteDoctor

data class FavoriteDoctorUI(
    override val id: Int,
    val doctor_data: String,
    val user_data: String,
    val doctor: String
) : IBaseDiffModel<Int>

fun FavoriteDoctor.toFavoriteDoctorUI() = FavoriteDoctorUI(
    id, doctor_data, user_data, doctor
)
