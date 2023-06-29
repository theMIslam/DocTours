package com.example.doctour.domain.model

data class Speciality(
    val id: Int,
    val name: String
)
data class ListSpecialty(
    val specialty:List<Speciality>
)
