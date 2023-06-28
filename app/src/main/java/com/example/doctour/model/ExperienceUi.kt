package com.example.doctour.model

import com.example.doctour.base.IBaseDiffModel
import com.example.doctour.domain.model.Experience

data class ExperienceUi(
    override val id: Int,
    val year: String,
    val title: String,
    val doctor: Int
):IBaseDiffModel<Int>
fun Experience.toExperienceUI()=ExperienceUi(
    id, year, title, doctor
)
