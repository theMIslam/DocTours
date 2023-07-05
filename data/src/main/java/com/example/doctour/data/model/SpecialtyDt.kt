package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.Speciality

data class SpecialtyDt(
    val id: String,
    val name: String?
) : DataMapper<Speciality> {
    override fun mapToDomain() = Speciality(
        id,
        name
    )
}