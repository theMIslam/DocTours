package com.example.doctour.presentation.model

import com.example.doctour.domain.model.City

data class CityUi(
    val id: String,
    val name: String?
)

fun City.toCityUi() = CityUi(
    id=id, name=name
)