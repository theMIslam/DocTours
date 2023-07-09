package com.example.doctour.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.Doctor
import com.google.gson.annotations.SerializedName

data class DoctorDt(
    @SerializedName("average_rating")
    val average_rating: String?,
    @SerializedName("clinic")
    val clinic: List<ClinicDt>?= emptyList(),
    @SerializedName("experience")
    val experience: Int?,
    @SerializedName("full_name")
    val full_name: String?,
    val id: String,
    @SerializedName("num_reviews")
    val num_reviews:String?,
    @SerializedName("photo")
    val photo: String?,
    @SerializedName("price")
    val price: Int?,
    @SerializedName("specialties")
    val specialties:List<SpecialtyDt>?= emptyList(),
    @SerializedName("summary")
    val summary: String?,
    @SerializedName("instagram")
    val instagram :String?,
    @SerializedName("doctor_reviews")
    val doctor_reviews:List<ReviewDt> ?= emptyList(),
    @SerializedName("isChoosen")
    val isChoosen :Boolean = false
) : DataMapper<Doctor> {
    override fun mapToDomain() = Doctor(
        average_rating=average_rating,
        clinic?.map { it.mapToDomain() },
        experience=experience,
        full_name=full_name,
        id=id,
        num_reviews=num_reviews,
        photo=photo,
        price=price,
        specialties?.map { it.mapToDomain() },
        summary=summary,
        instagram=instagram,
        doctor_reviews?.map { it.mapToDomain()},
        isChoosen
    )
}
