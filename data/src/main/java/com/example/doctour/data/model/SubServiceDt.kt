package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.SubService

data class SubServiceDt(
    val id:String,
    val name:String?,
    val slug:String?,
    val price:Int?,
    val count_clinic:String?,
    val service:String?,
    val clinic:List<ClinicDt> ?= emptyList()
):DataMapper<SubService>{
    override fun mapToDomain()= SubService(
        id,
        name,
        slug=slug,
        price,
        count_clinic,
        service,
        clinic?.map { it.mapToDomain() }
    )
}
