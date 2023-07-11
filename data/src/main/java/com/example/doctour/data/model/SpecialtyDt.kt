package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.Speciality
import com.google.gson.annotations.SerializedName

data class SpecialtyDt(
    val id: String,
    val name: String?,
    val doctors_count:String?
) : DataMapper<Speciality> {
    override fun mapToDomain() = Speciality(
        id,
        name,
        doctors_count
    )
}