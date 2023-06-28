package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.Speciality

data class SpecialtyDtResponse (
    val count:Int,
    val next:String?,
    val previous:String?,
    val result:List<SpecialtyDt>
        )
data class SpecialtyDt(
    val id: Int,
    val name: String,
    val name_ky: String,
    val name_ru: String
) : DataMapper<Speciality> {
    override fun mapToDomain() = Speciality(
        id,
        name,
        name_ru,
        name_ky
    )
}