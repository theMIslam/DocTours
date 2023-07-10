package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.Review
import com.google.gson.annotations.SerializedName

data class ReviewDt(
    val doctor: String?,
    val id: String,
    val stars: Int?,
    val text: String?,
    val doctor_name:String?,
    val user_name : String?,
    val user :Int?,
    val date:String?
) : DataMapper<Review> {
    override fun mapToDomain() = Review(
        doctor, id, stars, text,doctor_name, user_name, user, date
    )
}

fun Review.toReviewDt ()=ReviewDt(
    doctor, id, stars, text, doctor_name, user_name, user, date
)
