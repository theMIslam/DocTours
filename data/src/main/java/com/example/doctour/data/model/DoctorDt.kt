package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.doctorDetail.Doctor

data class DoctorDt(
    val id: String,
    val full_name: String?,
    val photo: String?,
    val summary: String?,
    val experience: Int?,
    val price: Int?,
    val instagram :String?,
    val average_rating: String?,
    val num_reviews:String?,
    val specialties:List<SpecialitySerializerFieldsDt>?= emptyList(),
    val clinic: List<ClinicSerializerFieldsDt>?= emptyList(),
    val isChoosen :Boolean = false
) : DataMapper<Doctor> {
    override fun mapToDomain() = Doctor(
        id,
        full_name,
        photo,
        summary,
        experience,
        price,
        instagram,
        average_rating,
        num_reviews,
        specialties?.map { it.mapToDomain() },
        clinic?.map { it.mapToDomain() },
        isChoosen
    )
}
