package com.example.doctour.presentation.model

import com.example.doctour.base.IBaseDiffModel
import com.example.doctour.domain.model.Doctor

data class DoctorUi(
    override val id: String,
    val average_rating: String?,
    val clinic:List<ClinicsUi>?= emptyList(),
    val experience: Int?,
    val full_name: String?,
    val num_reviews:String?,
    val photo: String?,
    val price: Int?,
    val specialties: List<SpecialityUi>?= emptyList(),
    val summary: String?,
    val instagram :String?,
    val doctor_reviews:List<ReviewUi>?= emptyList(),
    val isChoosen :Boolean = false
) : IBaseDiffModel<String>,java.io.Serializable
fun Doctor.toDoctorUi() = DoctorUi(
    id=id,
    average_rating=average_rating,
    clinic?.map { it.toClinicsUi() },
    experience=experience,
    full_name=full_name,
    num_reviews=num_reviews,
    photo=photo,
    price=price,
    specialties?.map { it.toSpecialityUi() },
    summary=summary,
    instagram=instagram,
    doctor_reviews?.map { it.toReviewUi() },
    isChoosen
)
fun  DoctorUi.toDoctorDmn()=Doctor(
    id,
    clinic?.map { it.toClinicDmn() },
    experience,
    full_name,
    id,
    num_reviews,
    photo,
    price,
    specialties?.map { it.toSpecialityDmn() },
    summary,
    instagram
)