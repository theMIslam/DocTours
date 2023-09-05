package com.example.doctour.data.model.doctor

import com.example.doctour.data.model.certificates.CertificatesDt
import com.example.doctour.data.model.clinics.ClinicSerializerFieldsDt
import com.example.doctour.data.model.education.EducationDt
import com.example.doctour.data.model.experience.ExperienceDt
import com.example.doctour.data.model.speciality.SpecialitySerializerFieldsDt
import com.example.doctour.data.model.speciality.SpecializationDt
import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.doctorDetail.DoctorDetail

data class DoctorDetailDt(
    val id: String,
    val average_rating: String?,
    val num_reviews: String?,
    val specialties: List<SpecialitySerializerFieldsDt>?= emptyList(),
    val clinic: List<ClinicSerializerFieldsDt>,
    val doctor_experience: List<ExperienceDt>?= emptyList(),
    val doctor_certificates: List<CertificatesDt>?= emptyList(),
    val doctor_education: List<EducationDt>?= emptyList(),
    val doctor_specialization: List<SpecializationDt>?= emptyList(),
    val is_deleted:Boolean,
    val created_at:String?,
    val updated_at:String?,
    val photo: String?,
    val full_name: String?,
    val experience: Int?,
    val instagram:String?,
    val price: Int?,
    val summary: String?,
    val phone: String?,
    val city: Int?,
    val category_services: List<Int>?= emptyList(),
) : DataMapper<DoctorDetail> {
    override fun mapToDomain() = DoctorDetail(
       id,
        average_rating,
        num_reviews,
        specialties?.map { it.mapToDomain() },
        clinic.map { it.mapToDomain() },
        doctor_experience?.map { it.mapToDomain() },
        doctor_certificates?.map { it.mapToDomain() },
        doctor_education?.map { it.mapToDomain() },
        doctor_specialization?.map { it.mapToDomain() },
        is_deleted,
        created_at,
        updated_at,
        photo,
        full_name,
        experience,
        instagram,
        price,
        summary,
        phone,
        city
    )
}
