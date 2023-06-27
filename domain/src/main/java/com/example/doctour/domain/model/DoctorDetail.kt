package com.example.doctour.domain.model

data class DoctorDetail(
    val id:Int,
    val doctor_reviews:List<Review>,
    val average_rating:String,
    val num_reviews:String,
    val specialties :List<Speciality>,
    val clinic:List<Clinics>,
    val category_services:List<Service>,
    val city:City,
    val doctor_experience:List<Experience>,
    val doctor_certificates:List<Certificates>,
    val doctor_education:List<Education>,
    val doctor_specialization:List<Specialization>,
    val photo:String,
    val full_name:String,
    val experience:Int,
    val price:Int,
    val summary:String,
    val summary_ru:String,
    val summary_ky:String,
    val phone:String
)
