package com.example.doctour.presentation.model.doctour

import com.example.doctour.base.IBaseDiffModel
import com.example.doctour.presentation.model.education.EducationUI
import com.example.doctour.presentation.model.experience.ExperienceUI
import com.example.doctour.presentation.model.speciality.SpecialitySerializerFieldsUI
import com.example.doctour.presentation.model.speciality.SpecializationUI
import com.example.doctour.presentation.model.certificates.CertificatesUI
import com.example.doctour.presentation.model.clinic.ClinicSerializerFieldsUI

data class DoctorDetailUI(
    override val id: String,
    val average_rating: String?,
    val num_reviews: String?,
    val specialties: List<SpecialitySerializerFieldsUI>? = emptyList(),
    val clinic: List<ClinicSerializerFieldsUI>,
    val doctor_experience: List<ExperienceUI>? = emptyList(),
    val doctor_certificates: List<CertificatesUI>? = emptyList(),
    val doctor_education: List<EducationUI>? = emptyList(),
    val doctor_specialization: List<SpecializationUI>? = emptyList(),
    val is_deleted: Boolean,
    val created_at: String?,
    val updated_at: String?,
    val photo: String?,
    val full_name: String?,
    val experience: Int?,
    val instagram: String?,
    val price: Int?,
    val summary: String?,
    val phone: String?,
    val city: Int?,
    val category_services: List<Int>? = emptyList(),
) : IBaseDiffModel<String>
