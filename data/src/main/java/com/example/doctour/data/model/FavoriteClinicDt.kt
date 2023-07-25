package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.FavoriteClinic

data class FavoriteClinicDt(
    val id:Int,
    val clinic_data:String,
    val user_data:String,
    val clinics:String
):DataMapper<FavoriteClinic>{
    override fun mapToDomain()= FavoriteClinic(
        id, clinic_data, user_data, clinics
    )
}
