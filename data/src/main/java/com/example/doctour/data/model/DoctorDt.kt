package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.Doctor

data class DoctorDt(
    val average_rating: Double,
    val clinic: List<ClinicDt>,
    val experience: Int,
    val full_name: String,
    val id: Int,
    val num_reviews: Int,
    val phone: String,
    val photo: String,
    val price: Int,
    val specialties: List<SpecialtyDt>,
    val summary: String,
    val summary_ky: String,
    val summary_ru: String,
    val city: CityDt
) : DataMapper<Doctor> {
    override fun mapToDomain() = Doctor(
        average_rating,
        clinic.map { it.mapToDomain() },
        experience,
        full_name,
        id,
        num_reviews,
        phone,
        photo,
        price,
        specialties.map { it.mapToDomain() },
        summary,
        summary_ky,
        summary_ru,
        city.mapToDomain()
    )
}
