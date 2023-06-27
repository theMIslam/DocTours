package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.SubService

data class SubServiceDt(
    val id:Int,
    val name:String,
    val price:Int,
    val num_clinic:String,
    val service:Int,
    val clinic:List<ClinicsDt>
):DataMapper<SubService>{
    override fun mapToDomain()= SubService(
        id,
        name,
        price,
        num_clinic,
        service,
        clinic.map { it.mapToDomain() }
    )
}
