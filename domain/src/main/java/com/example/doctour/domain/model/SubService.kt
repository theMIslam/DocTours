package com.example.doctour.domain.model

data class SubService(
    val id:Int,
    val name:String?,
    val slug:String?,
    val count_clinic:String?,
    val service:Int?,
    val clinic:List<Clinic> ?= emptyList()
)
