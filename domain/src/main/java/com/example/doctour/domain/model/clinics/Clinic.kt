package com.example.doctour.domain.model.clinics

data class Clinic(
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
)