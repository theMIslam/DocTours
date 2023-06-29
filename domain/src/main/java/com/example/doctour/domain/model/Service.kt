package com.example.doctour.domain.model

data class Service(
     val description: String,
     val id: Int,
     val name: String,
     val price: Int,
     val subservice_service: List<SubService>?= emptyList()
)