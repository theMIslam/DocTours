package com.example.doctour.domain.model

data class Doctor(
    val average_rating: Double,
    val clinic: List<Clinic>,
    val experience: Int,
    val full_name: String,
    val id: Int,
    val num_reviews: Int,
    val phone: String,
    val photo: String,
    val price: Int,
    val specialties: List<Speciality>,
    val summary: String,
    val summary_ky: String,
    val summary_ru: String,
    val city:City
)
