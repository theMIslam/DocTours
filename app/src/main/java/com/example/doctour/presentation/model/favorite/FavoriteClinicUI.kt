package com.example.doctour.presentation.model.favorite

import com.example.doctour.base.IBaseDiffModel
import com.example.doctour.domain.model.favoriteClinics.FavoriteClinic

data class FavoriteClinicUI(
    override val id: Int,
    val clinic_data: String,
    val user_data: String,
    val clinics: String
) : IBaseDiffModel<Int>

fun FavoriteClinic.toFavoriteClinicUI() = FavoriteClinicUI(
    id, clinic_data, user_data, clinics
)
