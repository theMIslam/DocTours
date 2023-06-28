package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.Review

data class ReviewDt(
    val doctor: Int,
    val id: Int,
    val stars: Int,
    val text: String
) : DataMapper<Review> {
    override fun mapToDomain() = Review(
        doctor, id, stars, text
    )
}
