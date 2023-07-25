package com.example.doctour.domain.model

data class Service(
    val slug: String,
    val name: String?,
    val subservice_service: List<SubService>?= emptyList()
)
