package com.example.doctour.presentation.model

import com.example.doctour.base.IBaseDiffModel
import com.example.doctour.domain.model.Experience

data class ExperienceUi(
    override val id: String,
    val year: String?,
    val title: String?,
    val doctor: Int?
):IBaseDiffModel<String>
fun Experience.toExperienceUI()=ExperienceUi(
    id=id, year=year, title=title, doctor=doctor
)
