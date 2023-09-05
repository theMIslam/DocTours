package com.example.doctour.data.model.education

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.education.Education

data class EducationDt(
    val id: String,
    val is_deleted:Boolean,
    val created_at:String?,
    val updated_at:String?,
    val title: String?,
    val specialization: String?,
    val year: String?,
    val doctor: String?
) : DataMapper<Education> {
    override fun mapToDomain() = Education(
        id,
        is_deleted,
        created_at,
        updated_at,
        title,
        specialization,
        year,
        doctor
    )
}
