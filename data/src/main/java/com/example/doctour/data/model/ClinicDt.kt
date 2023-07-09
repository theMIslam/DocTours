package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.Clinics
import com.google.gson.annotations.SerializedName

data class ClinicDt(
    @SerializedName("address")
    val address: String?,
    @SerializedName("contacts1")
    val contacts1: Long?,
     @SerializedName("contacts2")
    val contacts2: Long?,
     @SerializedName("descriptions")
    val descriptions: String?,
     @SerializedName("ending_working_day")
    val ending_working_day: String?,
     @SerializedName("id")
    val id: String,
     @SerializedName("link_2gis")
    val link_2gis: String?,
     @SerializedName("link_clinic")
    val link_clinic: String?,
     @SerializedName("photo")
    val photo: String?,
     @SerializedName("starting_working_day")
    val starting_working_day: String?,
     @SerializedName("title")
    val title: String?,
     @SerializedName("weekday")
    val weekday: String?,
     @SerializedName("weekend")
    val weekend: String?,
     @SerializedName("slug")
    val slug:String?
) : DataMapper<Clinics> {
    override fun mapToDomain() = Clinics(
        address,
        contacts1,
        contacts2,
        descriptions,
        ending_working_day,
        id,
        link_2gis,
        link_clinic,
        photo,
        starting_working_day,
        title,
        weekday,
        weekend,
        slug
    )
}
