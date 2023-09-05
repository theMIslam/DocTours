package com.example.doctour.data.model.speciality

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.speciality.Specialization

data class SpecializationDt(
    val id: String,
    val is_deleted:Boolean,
    val created_at:String?,
    val updated:String?,
    val title: String?,
    val doctor: String?
) : DataMapper<Specialization> {
    override fun mapToDomain() = Specialization(
        id,
        is_deleted,
        created_at,
        updated,
        title,
        doctor
    )
}
