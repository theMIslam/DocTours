package com.example.doctour.domain.model.doctorDetail

import com.example.doctour.domain.model.certificates.Certificates
import com.example.doctour.domain.model.education.Education
import com.example.doctour.domain.model.experience.Experience
import com.example.doctour.domain.model.speciality.SpecialitySerializerFields
import com.example.doctour.domain.model.speciality.Specialization
import com.example.doctour.domain.model.clinics.ClinicSerializerFields

data class DoctorDetail(
    val id: String,
    val average_rating: String?,
    val num_reviews: String?,
    val specialties: List<SpecialitySerializerFields>?= emptyList(),
    val clinic: List<ClinicSerializerFields>,
    val doctor_experience: List<Experience>?= emptyList(),
    val doctor_certificates: List<Certificates>?= emptyList(),
    val doctor_education: List<Education>?= emptyList(),
    val doctor_specialization: List<Specialization>?= emptyList(),
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
)
