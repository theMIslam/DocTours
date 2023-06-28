package com.example.doctour.model

import com.example.doctour.base.IBaseDiffModel
import com.example.doctour.domain.model.Education

data class EducationUi(
    override val id: Int,
    val year: String,
    val title: String,
    val specialization: String,
    val doctor: Int
):IBaseDiffModel<Int>
fun Education.toEducationUi()=EducationUi(
    id, year, title, specialization, doctor
)
