package com.example.doctour.domain.model

data class DoctorDetail(
    val id:String,
    val doctor_reviews:List<Review>?= emptyList(),
    val average_rating:String?,
    val num_reviews:String?,
    val specialties :List<Speciality>?= emptyList(),
    val clinic:List<Clinics>?= emptyList(),
    val category_services:List<Service>?= emptyList(),
    val city:City,
    val doctor_experience:List<Experience>?= emptyList(),
    val doctor_certificates:List<Certificates>?= emptyList(),
    val doctor_education:List<Education>?= emptyList(),
    val doctor_specialization:List<Specialization>?= emptyList(),
    val photo:String?,
    val full_name:String?,
    val experience:Int?,
    val instagram :String?,
    val price:Int?,
    val summary:String?,
    val phone:String?
)
