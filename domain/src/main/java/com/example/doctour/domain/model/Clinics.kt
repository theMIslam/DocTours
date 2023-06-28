package com.example.doctour.domain.model

data class Clinics(
    val address: String,
    val contacts1: Long,
    val contacts2: Long,
    val descriptions: String,
    val ending_working_day: String,
    val id: Int,
    val link_2gis: String,
    val link_clinic: String,
    val photo: String,
    val starting_working_day: String,
    val title: String,
    val weekday: String,
    val weekend: String
)
