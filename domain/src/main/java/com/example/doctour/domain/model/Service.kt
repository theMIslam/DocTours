package com.example.doctour.domain.model

data class Service(
     val description: String?,
     val id: String,
     val name: String?,
     val slug:String?,
     val price: Int?,
     val subservice_service: List<SubService>?= emptyList()
)