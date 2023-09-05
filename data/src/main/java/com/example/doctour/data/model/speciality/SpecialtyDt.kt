package com.example.doctour.data.model.speciality

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.speciality.Specialty

data class SpecialtyDt(
    val id: Int,
    val slug:String,
    val name: String?,
    val doctors_count:String?
) : DataMapper<Specialty> {
    override fun mapToDomain() = Specialty(
       id, slug, name, doctors_count
    )
}