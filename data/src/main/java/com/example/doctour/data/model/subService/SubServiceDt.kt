package com.example.doctour.data.model.subService

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.clinics.Clinic
import com.example.doctour.domain.model.subService.SubService

data class SubServiceDt(
    val id:Int,
    val name:String?,
    val slug:String?,
    val count_clinic:String?,
    val service:Int?,
    val clinic:List<ClinicDt> ?= emptyList()
):DataMapper<SubService>{
    override fun mapToDomain()= SubService(
        id,
        name,
        slug=slug,
        count_clinic,
        service,
        clinic?.map { it.mapToDomain() }
    )
}

data class ClinicDt(
    val id: String,
    val is_deleted :Boolean ,
    val created_at :String?,
    val updated_at :String?,
    val title: String?,
    val descriptions:String?,
    val photo: String?,
    val address: String?,
    val link_clinic: String?,
    val link_2gis: String?,
    val starting_working_day: String?,
    val contacts1: String?,
    val contacts2: String?,
    val ending_working_day: String?,
    val weekday: String?,
    val weekend: String?,
    val  city:Int?
) : DataMapper<Clinic> {
    override fun mapToDomain() = Clinic(
        id,
        is_deleted,
        created_at,
        updated_at,
        title,
        descriptions,
        photo,
        address,
        link_clinic,
        link_2gis,
        starting_working_day,
        contacts1,
        contacts2,
        ending_working_day,
        weekday,
        weekend,
        city
    )
}
