package com.example.doctour.domain.model

data class Service(
     val id:Int,
     val name:String,
     val price:Int,
     val description:String,
     val subservice_service:List<SubService>
)