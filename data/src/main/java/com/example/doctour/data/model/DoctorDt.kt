package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.Doctor
import com.google.gson.annotations.SerializedName

data class DoctorDt(
    val average_rating: String?,
    val clinic: List<ClinicDt>?= emptyList(),
    val experience: Int?,
    val full_name: String?,
    val id: String,
    val num_reviews:String?,
    val photo: String?,
    val price: Int?,
    val specialties:List<SpecialtyDt>?= emptyList(),
    val summary: String?,
    val instagram :String?,
    val doctor_reviews:List<ReviewDt> ?= emptyList(),
    val isChoosen :Boolean = false
) : DataMapper<Doctor> {
    override fun mapToDomain() = Doctor(
        average_rating=average_rating,
        clinic?.map { it.mapToDomain() },
        experience=experience,
        full_name=full_name,
        id=id,
        num_reviews=num_reviews,
        photo=photo,
        price=price,
        specialties?.map { it.mapToDomain() },
        summary=summary,
        instagram=instagram,
        doctor_reviews?.map { it.mapToDomain()},
        isChoosen
    )
}
