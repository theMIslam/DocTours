package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.Service

data class ServiceDtResponse (
    val count:Int,
    val next:String?,
    val previous:String?,
    val result:List<ServiceDt>
        )
data class ServiceDt(
    val description: String,
    val id: Int,
    val name: String,
    val price: Int,
    val subservice_service: List<SubServiceDt>
):DataMapper<Service>{
    override fun mapToDomain()= Service(
       description,
        id,
        name,
        price,
        subservice_service.map { it.mapToDomain() }
    )
}
