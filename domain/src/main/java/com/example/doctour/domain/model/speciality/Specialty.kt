package com.example.doctour.domain.model.speciality

data class Specialty(
    val id: Int,
    val slug:String,
    val name: String?,
    val doctors_count:String?
)