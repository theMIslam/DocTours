package com.example.doctour.presentation.model

import com.example.doctour.base.IBaseDiffModel
import com.example.doctour.domain.model.Doctor

data class DoctorUI(
    override val id: String,
    val full_name: String?,
    val photo: String?,
    val summary: String?,
    val experience: Int?,
    val price: Int?,
    val instagram :String?,
    val average_rating: String?,
    val num_reviews:String?,
    val specialties:List<SpecialitySerializerFieldsUI>?= emptyList(),
    val clinic: List<ClinicSerializerFieldsUI>?= emptyList(),
    val isChoosen :Boolean = false
): IBaseDiffModel<String>

fun Doctor.toDoctorUI()=DoctorUI(
    id,
    full_name,
    photo,
    summary,
    experience,
    price,
    instagram,
    average_rating,
    num_reviews,
    specialties?.map { it.toSpecialitySerializerFieldsUI() },
    clinic?.map { it.toClinicSerializerFieldsUI() },
    isChoosen
)
