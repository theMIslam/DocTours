package com.example.doctour.domain.model

data class Clinics(
    val id :Int,
    val photo:String,
    val link_clinic:String,
    val link_2gis:String,
    val descriptions:String,
    val descriptions_ru:String,
    val descriptions_ky:String,
    val starting_working_day:String,
    val ending_working_day:String,
    val address:String,
    val contacts1:Int,
    val contacts2:Int,
    val weekday:String,
    val weekend:String
)
