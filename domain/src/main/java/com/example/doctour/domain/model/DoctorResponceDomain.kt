package com.example.doctour.domain.model

data class DoctorResponceDomain(
    val count:Int,
    val next:String?,
    val previous:String?,
    val results:List<Doctor>
)
