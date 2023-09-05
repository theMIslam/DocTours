package com.example.doctour.presentation.model.clinic

import com.example.doctour.base.IBaseDiffModel
import com.example.doctour.domain.model.clinics.Clinic

data class ClinicUI(
    override val id: String,
    val is_deleted: Boolean,
    val created_at: String?,
    val updated_at: String?,
    val title: String?,
    val descriptions: String?,
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
    val city: Int?
) : IBaseDiffModel<String>

fun Clinic.toClinicUI() = ClinicUI(
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
