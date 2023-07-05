package com.example.doctour.domain.model

data class Review(
    val doctor:String?,
    val id: String,
    val stars: Int?,
    val text: String?,
    val doctor_name:String?,
    val user_name : String?,
    val user :Int?,
    val date:String?
)
