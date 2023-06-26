package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.Review

data class ReviewDt(
    val id: Int,
    val text: String,
    val stars: Int,
    val doctor: List<Int>
) : DataMapper<Review> {
    override fun mapToDomain() = Review(
        id,
        text,
        stars,
        doctor
    )
}
