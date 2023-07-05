package com.example.doctour.domain.model

data class SubService(
    val id:String,
    val name:String?,
    val slug:String?,
    val price:Int?,
    val count_clinic:String?,
    val service:String?,
    val clinic:List<Clinics>?= emptyList()
)