package com.example.doctour.data.model.experience

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.experience.Experience

data class ExperienceDt(
    val id: String,
    val is_deleted:Boolean,
    val created_at:String?,
    val updated_at:String?,
    val title: String?,
    val year: String?,
    val doctor: String?
) : DataMapper<Experience> {
    override fun mapToDomain() = Experience(
       id,
        is_deleted,
        created_at,
        updated_at,
        title,
        year,
        doctor
    )
}
