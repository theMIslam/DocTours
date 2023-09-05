package com.example.doctour.domain.model.reviews

data class Review(
    val id: String,
    val text: String?,
    val stars: Int?,
    val doctor: String?,
    val doctor_name:String?,
    val user_name : String?,
    val created_at:String?
)
