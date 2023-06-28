package com.example.doctour.model

import com.example.doctour.base.IBaseDiffModel
import com.example.doctour.data.model.CertificatesDt
import com.example.doctour.data.model.CityDt
import com.example.doctour.data.model.ClinicDt
import com.example.doctour.data.model.EducationDt
import com.example.doctour.data.model.ExperienceDt
import com.example.doctour.data.model.ReviewDt
import com.example.doctour.data.model.ServiceDt
import com.example.doctour.data.model.SpecializationDt
import com.example.doctour.data.model.SpecialtyDt
import com.example.doctour.domain.model.DoctorDetail

data class DoctorDetailUi(
    override val id: Int,
    val doctor_reviews: List<ReviewUi>,
    val average_rating: String,
    val num_reviews: String,
    val specialties: List<SpecialityUi>,
    val clinic: List<ClinicsUi>,
    val category_services: List<ServiceUi>,
    val city: CityUi,
    val doctor_experience: List<ExperienceUi>,
    val doctor_certificates: List<CertificatesUi>,
    val doctor_education: List<EducationUi>,
    val doctor_specialization: List<SpecializationUI>,
    val photo: String,
    val full_name: String,
    val experience: Int,
    val price: Int,
    val summary: String,
    val summary_ru: String,
    val summary_ky: String,
    val phone: String
) : IBaseDiffModel<Int>

fun DoctorDetail.toDoctorDetailUi() = DoctorDetailUi(
    id,
    doctor_reviews.map { it.toReviewUi() },
    average_rating,
    num_reviews,
    specialties.map { it.toSpecialityUi() },
    clinic.map { it.toClinicsUi() },
    category_services.map { it.toServiceUi() },
    city.toCityUi(),
    doctor_experience.map { it.toExperienceUI() },
    doctor_certificates.map { it.toCertificatesUi() },
    doctor_education.map { it.toEducationUi() },
    doctor_specialization.map { it.toSpecializationUi() },
    photo,
    full_name,
    experience,
    price,
    summary,
    summary_ru,
    summary_ky,
    phone
)
