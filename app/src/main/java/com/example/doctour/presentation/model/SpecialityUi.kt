package com.example.doctour.presentation.model

import com.example.doctour.base.IBaseDiffModel
import com.example.doctour.domain.model.Speciality

data class SpecialityUi(
    override val id: String,
    val name: String?,
    val doctors_count:Int?
): IBaseDiffModel<String>

fun Speciality.toSpecialityUi() = SpecialityUi(
    id=id, name=name,doctors_count=doctors_count
)

fun SpecialityUi.toSpecialityDmn()=Speciality(
    id=id, name=name, doctors_count=doctors_count
)