package com.example.doctour.domain.model.doctorDetail

import com.example.doctour.domain.model.speciality.SpecialitySerializerFields
import com.example.doctour.domain.model.clinics.ClinicSerializerFields

data class Doctor(
    val id: String,
    val full_name: String?,
    val photo: String?,
    val summary: String?,
    val experience: Int?,
    val price: Int?,
    val instagram :String?,
    val average_rating: String?,
    val num_reviews:String?,
    val specialties:List<SpecialitySerializerFields>?= emptyList(),
    val clinic: List<ClinicSerializerFields>?= emptyList(),
    val isChoosen :Boolean = false
)
