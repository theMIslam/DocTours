package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.ListSpecialty
import com.example.doctour.domain.model.Speciality

data class SpecialtyDt(
    val id: Int,
    val name: String?
) : DataMapper<Speciality> {
    override fun mapToDomain() = Speciality(
        id,
        name
    )
}
data class ListSpecialtyDt(
    val specialty:List<SpecialtyDt>
):DataMapper<ListSpecialty>{
    override fun mapToDomain(): ListSpecialty = ListSpecialty(
        specialty.map { it.mapToDomain() }
    )
}