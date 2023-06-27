package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.Service


data class ServiceDt(
    val id:Int,
    val name:String,
    val price:Int,
    val description:String,
    val subservice_service:List<SubServiceDt>
):DataMapper<Service>{
    override fun mapToDomain()= Service(
        id,
        name,
        price,
        description,
        subservice_service.map { it.mapToDomain() }
    )
}
