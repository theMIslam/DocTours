package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.Specialization

data class SpecializationDt(
    val id: Int,
    val title: String?,
    val doctor: Int?
) : DataMapper<Specialization> {
    override fun mapToDomain() = Specialization(
        id,
        title,
        doctor
    )
}
