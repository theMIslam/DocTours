package com.example.doctour.presentation.model

import com.example.doctour.domain.model.ReviewBody

data class ReviewBodyUI(
    val text:String,
    val stars:Int,
    val doctor:String
)
fun ReviewBody.toReviewBodyUI()=ReviewBodyUI(
    text,stars, doctor
)

fun ReviewBodyUI.toReviewBody()=ReviewBody(
    text, stars, doctor
)
