package com.example.doctour.data.remote.dtos.doctour

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
class DoctourPagingResponse<T>(
    @Json(name = "prev")
    val prev: Int?,
    @Json(name = "next")
    val next: Int?,
    @Json(name = "data")
    val data: MutableList<T>
)
