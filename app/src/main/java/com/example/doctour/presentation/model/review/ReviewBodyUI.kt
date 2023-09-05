package com.example.doctour.presentation.model.review

import com.example.doctour.domain.model.reviews.ReviewBody

data class ReviewBodyUI(
    val text:String,
    val stars:Int,
    val doctor:String
)
fun ReviewBody.toReviewBodyUI()= ReviewBodyUI(
    text,stars, doctor
)

fun ReviewBodyUI.toReviewBody()= ReviewBody(
    text, stars, doctor
)
