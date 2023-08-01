package com.example.doctour.presentation.model

import com.example.doctour.base.IBaseDiffModel
import com.example.doctour.domain.model.ClinicSerializerFields

data class ClinicSerializerFieldsUI(
    override val id:String,
    val title:String
): IBaseDiffModel<String>

fun ClinicSerializerFields.toClinicSerializerFieldsUI()=ClinicSerializerFieldsUI(
    id, title
)
