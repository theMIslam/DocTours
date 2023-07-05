package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.Education

data class EducationDt(
    val id: String,
    val year: String?,
    val title: String?,
    val specialization: String?,
    val doctor: Int?
) : DataMapper<Education> {
    override fun mapToDomain() = Education(
        id,
        year,
        title,
        specialization,
        doctor
    )
}
