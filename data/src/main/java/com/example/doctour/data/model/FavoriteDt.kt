package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.Favorite

data class FavoriteDt(
    val id: String,
    val user: Int,
    val doctor: Int
) : DataMapper<Favorite> {
    override fun mapToDomain() = Favorite(
        id,
        user,
        doctor
    )
}
