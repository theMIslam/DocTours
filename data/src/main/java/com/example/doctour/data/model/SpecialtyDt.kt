package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.Speciality
import com.google.gson.annotations.SerializedName

data class SpecialtyDt(
    @SerializedName("id")
    val id: String,
    @SerializedName("name")
    val name: String?
) : DataMapper<Speciality> {
    override fun mapToDomain() = Speciality(
        id,
        name
    )
}