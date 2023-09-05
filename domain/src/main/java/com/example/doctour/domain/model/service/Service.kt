package com.example.doctour.domain.model.service

import com.example.doctour.domain.model.subService.SubService

data class Service(
    val slug: String,
    val name: String?,
    val subservice_service: List<SubService>?= emptyList()
)
