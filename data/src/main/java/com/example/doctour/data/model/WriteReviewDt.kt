package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.WriteReview

data class WriteReviewDt(
    val text: String,
    val stars: Int,
    val doctor: String,
    val user: Long
) : DataMapper<WriteReview> {
    override fun mapToDomain() = WriteReview(
        text, stars, doctor, user
    )
}

fun WriteReview.toWriteReviewDt()=WriteReviewDt(
    text=text, stars=stars, doctor=doctor, user=user
)
