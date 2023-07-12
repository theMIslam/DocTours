package com.example.doctour.presentation.model

import com.example.doctour.base.IBaseDiffModel
import com.example.doctour.domain.model.Clinics

data class ClinicsUi(
    override val id: String,
    val is_deleted :Boolean?,
    val created_at :String?,
    val updated_at :String?,
    val photo: String?,
    val title: String?,
    val slug:String?,
    val link_clinic: String?,
    val link_2gis: String?,
    val descriptions: String?,
    val starting_working_day: String?,
    val ending_working_day: String?,
    val address: String?,
    val contacts1: Long?,
    val contacts2: Long?,
    val weekday: String?,
    val weekend: String?,
    val  city:String?
): IBaseDiffModel<String>

fun Clinics.toClinicsUi() = ClinicsUi(
    id,
    is_deleted,
    created_at,
    updated_at,
    photo,
    title,
    slug,
    link_clinic,
    link_2gis,
    descriptions,
    starting_working_day,
    ending_working_day,
    address,
    contacts1,
    contacts2,
    weekday,
    weekend,
    city
)

fun ClinicsUi.toClinicDmn()=Clinics(
    id,
    is_deleted,
    created_at,
    updated_at,
    photo,
    title,
    slug,
    link_clinic,
    link_2gis,
    descriptions,
    starting_working_day,
    ending_working_day,
    address,
    contacts1,
    contacts2,
    weekday,
    weekend,
    city
)