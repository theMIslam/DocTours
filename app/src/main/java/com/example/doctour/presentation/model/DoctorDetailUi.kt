package com.example.doctour.presentation.model

import com.example.doctour.base.IBaseDiffModel
import com.example.doctour.domain.model.DoctorDetail
import com.example.doctour.model.CertificatesUi
import com.example.doctour.model.EducationUi
import com.example.doctour.model.ExperienceUi
import com.example.doctour.model.SpecializationUI
import com.example.doctour.model.toCertificatesUi
import com.example.doctour.model.toEducationUi
import com.example.doctour.model.toExperienceUI
import com.example.doctour.model.toSpecializationUi

data class DoctorDetailUi(
    override val id: Int,
    val doctor_reviews:List<ReviewUi>?= emptyList(),
    val average_rating:String?,
    val num_reviews:String?,
    val specialties :List<SpecialityUi>?= emptyList(),
    val clinic:List<ClinicsUi>?= emptyList(),
    val category_services:List<ServiceUi>?= emptyList(),
    val city: CityUi,
    val doctor_experience:List<ExperienceUi>?= emptyList(),
    val doctor_certificates:List<CertificatesUi>?= emptyList(),
    val doctor_education:List<EducationUi>?= emptyList(),
    val doctor_specialization:List<SpecializationUI>?= emptyList(),
    val photo:String?,
    val full_name:String?,
    val experience:Int?,
    val instagram :String?,
    val price:Int?,
    val summary:String?,
    val phone:String?
) : IBaseDiffModel<Int>

fun DoctorDetail.toDoctorDetailUi() = DoctorDetailUi(
    id=id,
    doctor_reviews?.map { it.toReviewUi() },
    average_rating=average_rating,
    num_reviews=num_reviews,
    specialties?.map { it.toSpecialityUi() },
    clinic?.map { it.toClinicsUi() },
    category_services?.map { it.toServiceUi() },
    city.toCityUi(),
    doctor_experience?.map { it.toExperienceUI() },
    doctor_certificates?.map { it.toCertificatesUi() },
    doctor_education?.map { it.toEducationUi() },
    doctor_specialization?.map { it.toSpecializationUi() },
    photo=photo,
    full_name=full_name,
    experience=experience,
    instagram=instagram,
    price=price,
    summary=summary,
    phone=phone
)
