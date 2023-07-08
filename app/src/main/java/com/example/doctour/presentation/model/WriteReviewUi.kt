package com.example.doctour.presentation.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.WriteReview

data class WriteReviewUi(
    val text: String,
    val stars: Int,
    val doctor: String,
    val user: Long
):DataMapper<WriteReview>{
    override fun mapToDomain() = WriteReview(
        text, stars, doctor, user
    )
}

fun WriteReview.toWriteReviewUi() = WriteReviewUi(
    text, stars, doctor, user
)
