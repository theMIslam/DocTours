package com.example.doctour.data.model.service

import com.example.doctour.data.model.subService.SubServiceDt
import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.service.Service
data class ServiceDt(
    val slug: String,
    val name: String?,
    val subservice_service: List<SubServiceDt>?= emptyList()
):DataMapper<Service>{
    override fun mapToDomain()= Service(
        slug=slug,
        name=name,
        subservice_service?.map { it.mapToDomain() }
    )
}
