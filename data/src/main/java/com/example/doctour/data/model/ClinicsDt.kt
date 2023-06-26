package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.Clinics

data class ClinicsDt(
    val id: Int,
    val photo: String,
    val link_clinic: String,
    val link_2gis: String,
    val descriptions: String,
    val descriptions_ru: String,
    val descriptions_ky: String,
    val starting_working_day: String,
    val ending_working_day: String,
    val address: String,
    val contacts1: Int,
    val contacts2: Int,
    val weekday: String,
    val weekend: String
) : DataMapper<Clinics> {
    override fun mapToDomain() = Clinics(
        id,
        photo,
        link_clinic,
        link_2gis,
        descriptions,
        descriptions_ru,
        descriptions_ky,
        starting_working_day,
        ending_working_day,
        address,
        contacts1,
        contacts2,
        weekday,
        weekend
    )
}
