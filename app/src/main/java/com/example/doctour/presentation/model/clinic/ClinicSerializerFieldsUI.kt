package com.example.doctour.presentation.model.clinic

import com.example.doctour.base.IBaseDiffModel
import com.example.doctour.domain.model.clinics.ClinicSerializerFields

data class ClinicSerializerFieldsUI(
    override val id: String,
    val title: String
) : IBaseDiffModel<String>

fun ClinicSerializerFields.toClinicSerializerFieldsUI() = ClinicSerializerFieldsUI(
    id, title
)
