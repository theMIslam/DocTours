package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.City

data class CityDt(
    val id: String,
    val name: String?
) : DataMapper<City> {
    override fun mapToDomain() = City(
        id,
        name
    )

}
