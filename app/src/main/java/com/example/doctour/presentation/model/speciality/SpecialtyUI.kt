package com.example.doctour.presentation.model.speciality

import com.example.doctour.base.IBaseDiffModel
import com.example.doctour.domain.model.speciality.Specialty

data class SpecialtyUI(
    override val id: Int,
    val slug:String,
    val name: String?,
    val doctors_count:String?
): IBaseDiffModel<Int>

fun Specialty.toSpecialtyUI()= SpecialtyUI(
    id, slug, name, doctors_count
)