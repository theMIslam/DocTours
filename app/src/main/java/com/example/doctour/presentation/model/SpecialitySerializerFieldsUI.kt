package com.example.doctour.presentation.model

import com.example.doctour.domain.model.SpecialitySerializerFields

data class SpecialitySerializerFieldsUI(
    val slug:String,
    val name:String
)

fun SpecialitySerializerFields.toSpecialitySerializerFieldsUI()=SpecialitySerializerFieldsUI(
    slug, name
)
