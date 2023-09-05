package com.example.doctour.presentation.model.review

import com.example.doctour.base.IBaseDiffModel
import com.example.doctour.domain.model.reviews.Review

data class ReviewUI(
    override val id: String,
    val text: String?,
    val stars: Int?,
    val doctor: String?,
    val doctor_name:String?,
    val user_name : String?,
    val created_at:String?
): IBaseDiffModel<String>

fun Review.toReviewUI()= ReviewUI(
    id, text, stars, doctor, doctor_name, user_name, created_at
)
