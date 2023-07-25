package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.ReviewBody

data class ReviewBodyDt(
    val text: String,
    val stars: Int,
    val doctor: String
) : DataMapper<ReviewBody> {
    override fun mapToDomain() = ReviewBody(
        text, stars, doctor
    )
}

fun ReviewBody.toReviewBodyDt()=ReviewBodyDt(
    text, stars, doctor
)
