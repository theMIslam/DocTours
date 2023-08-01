package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.Review
import com.google.gson.annotations.SerializedName

data class ReviewDt(
    val id: String,
    val text: String?,
    val stars: Int?,
    val doctor: String?,
    val doctor_name:String?,
    val user_name : String?,
    val created_at:String?
) : DataMapper<Review> {
    override fun mapToDomain() = Review(
       id, text, stars, doctor, doctor_name, user_name, created_at
    )
}
