package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.Doctor

data class DoctorDt(
    val id: Int,
    val doctor_reviews: List<ReviewDt>,
    val average_rating: String,
    val num_reviews: String,
    val specialties: List<SpecialityDt>,
    val clinic: List<ClinicsDt>,
    val photo: String,
    val full_name: String,
    val experience: String,
    val price: Int,
    val summary: String,
    val summary_ru: String,
    val summary_ky: String,
    val phone: String
) : DataMapper<Doctor> {
    override fun mapToDomain() = Doctor(
        id,
        doctor_reviews.map { it.mapToDomain() },
        average_rating,
        num_reviews,
        specialties.map { it.mapToDomain() },
        clinic.map { it.mapToDomain() },
        photo,
        full_name,
        experience,
        price,
        summary,
        summary_ru,
        summary_ky,
        phone
    )
}
