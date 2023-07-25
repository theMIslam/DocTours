package com.example.doctour.presentation.model

import com.example.doctour.domain.model.Service

data class ServiceUi(
    val slug: String,
    val name: String?,
    val subservice_service: List<SubServiceUI>?= emptyList()
)

fun Service.toServiceUI()=ServiceUi(
    slug, name,subservice_service?.map { it.toSubServiceUI() }
)
