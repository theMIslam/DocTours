package com.example.doctour.data.remote.dtos.doctour

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.Doctour
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class DoctourDto(
    @Json(name = "id")
    val id: Long,
    @Json(name = "bar")
    val bar: String
) : DataMapper<Doctour> {

    override fun mapToDomain() = Doctour(id, bar)
}
