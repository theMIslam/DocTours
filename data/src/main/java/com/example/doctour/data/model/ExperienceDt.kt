package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.Experience

data class ExperienceDt(
    val id: Int,
    val year: String,
    val title: String,
    val doctor: Int
) : DataMapper<Experience> {
    override fun mapToDomain() = Experience(
        id,
        year,
        title,
        doctor
    )
}
