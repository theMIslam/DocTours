package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.Clinics
import com.example.doctour.domain.model.Doctor
import com.example.doctour.domain.model.DoctorResponse
import com.example.doctour.domain.model.Review
import com.example.doctour.domain.model.Speciality

data class DoctorDtResponse(
    val count:Int,
    val next:String?,
    val previous:String?,
    val result:List<DoctorDt>
):DataMapper<DoctorResponse>{
    override fun mapToDomain(): DoctorResponse= DoctorResponse(
        count,
        next,
        previous,
        result.map { it.mapToDomain() }
    )
}
data class DoctorDt(
    val average_rating: String,
    val clinic: List<ClinicDt>,
    val experience: Int,
    val full_name: String,
    val id: Int,
    val num_reviews:String,
    val photo: String,
    val price: Int,
    val specialties: List<SpecialtyDt>,
    val summary: String,
    val instagram :String,
    val doctor_reviews:List<ReviewDt>
) : DataMapper<Doctor> {
    override fun mapToDomain() = Doctor(
        average_rating,
        clinic.map { it.mapToDomain() },
        experience,
        full_name,
        id,
        num_reviews,
        photo,
        price,
        specialties.map { it.mapToDomain() },
        summary,
        instagram,
        doctor_reviews.map { it.mapToDomain() }
    )
}
