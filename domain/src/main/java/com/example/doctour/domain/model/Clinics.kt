package com.example.doctour.domain.model

data class Clinics(
    val id: String,
    val is_deleted :Boolean? ,
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
)
