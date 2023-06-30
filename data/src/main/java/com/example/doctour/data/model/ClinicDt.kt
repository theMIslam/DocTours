package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.Clinics
data class ClinicDt(
    val address: String?,
    val contacts1: Long?,
    val contacts2: Long?,
    val descriptions: String?,
    val ending_working_day: String?,
    val id: Int,
    val link_2gis: String?,
    val link_clinic: String?,
    val photo: String?,
    val starting_working_day: String?,
    val title: String?,
    val weekday: String?,
    val weekend: String
) : DataMapper<Clinics> {
    override fun mapToDomain() = Clinics(
        address,
        contacts1,
        contacts2,
        descriptions,
        ending_working_day,
        id,
        link_2gis,
        link_clinic,
        photo,
        starting_working_day,
        title,
        weekday,
        weekend
    )
}
