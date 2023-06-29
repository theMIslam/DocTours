package com.example.doctour.domain.model

data class Doctor(
    val average_rating: String?,
    val clinic: List<Clinics>,
    val experience: Int,
    val full_name: String,
    val id: Int,
    val num_reviews:String,
    val photo: String,
    val price: Int,
    val specialties:List<Speciality>,
    val summary: String,
    val instagram :String,
    val doctor_reviews:List<Review> ?= emptyList()
)
data class DoctorResponse(
    val results:List<Doctor>
)
