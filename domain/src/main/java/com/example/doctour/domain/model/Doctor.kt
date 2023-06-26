package com.example.doctour.domain.model

data class Doctor(
    val id:Int,
    val doctor_reviews:List<Review>,
    val average_rating:String,
    val num_reviews:String,
    val specialties:List<Speciality>,
    val clinic:List<Clinics>,
    val photo:String,
    val full_name:String,
    val experience:String,
    val price:Int,
    val summary:String,
    val summary_ru:String,
    val summary_ky:String,
    val phone:String
)
