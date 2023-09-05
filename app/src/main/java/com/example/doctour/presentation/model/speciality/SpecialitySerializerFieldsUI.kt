package com.example.doctour.presentation.model.speciality

import com.example.doctour.domain.model.speciality.SpecialitySerializerFields

data class SpecialitySerializerFieldsUI(
    val slug:String,
    val name:String
)

fun SpecialitySerializerFields.toSpecialitySerializerFieldsUI()= SpecialitySerializerFieldsUI(
    slug, name
)
