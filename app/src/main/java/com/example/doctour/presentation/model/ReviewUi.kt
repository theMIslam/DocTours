package com.example.doctour.presentation.model

import com.example.doctour.base.IBaseDiffModel
import com.example.doctour.domain.model.Review

data class ReviewUi(
    val doctor: String?,
    override val id: String,
    val stars: Int?,
    val text: String?,
    val doctor_name:String?,
    val user_name : String?,
    val user :Int?,
    val date:String?
): IBaseDiffModel<String>

fun Review.toReviewUi() = ReviewUi(
    id=id, text=text, stars=stars, doctor=doctor,
    doctor_name = doctor_name,
    user_name = user_name,
    user =user,
    date = date
)
