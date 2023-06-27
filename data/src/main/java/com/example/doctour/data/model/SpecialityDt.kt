package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.Speciality

data class SpecialityDt(
    val id: Int,
    val name: String,
    val name_ru: String,
    val name_ky: String
) : DataMapper<Speciality> {
    override fun mapToDomain() = Speciality(
        id,
        name,
        name_ru,
        name_ky
    )
}