package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.Review
import com.google.gson.annotations.SerializedName

data class ReviewDt(
    @SerializedName("doctor")
    val doctor: String?,
     @SerializedName("id")
    val id: String,
     @SerializedName("stars")
    val stars: Int?,
     @SerializedName("text")
    val text: String?,
     @SerializedName("doctor_name")
    val doctor_name:String?,
     @SerializedName("user_name")
    val user_name : String?,
     @SerializedName("user")
    val user :Int?,
     @SerializedName("date")
    val date:String?
) : DataMapper<Review> {
    override fun mapToDomain() = Review(
        doctor, id, stars, text,doctor_name, user_name, user, date
    )
}
