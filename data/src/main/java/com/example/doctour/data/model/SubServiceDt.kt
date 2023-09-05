package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.subService.SubService

data class SubServiceDt(
    val id:Int,
    val name:String?,
    val slug:String?,
    val count_clinic:String?,
    val service:Int?,
    val clinic:List<ClinicDt> ?= emptyList()
):DataMapper<SubService>{
    override fun mapToDomain()= SubService(
        id,
        name,
        slug=slug,
        count_clinic,
        service,
        clinic?.map { it.mapToDomain() }
    )
}
