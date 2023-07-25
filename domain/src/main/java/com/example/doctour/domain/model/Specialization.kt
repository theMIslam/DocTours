package com.example.doctour.domain.model

data class Specialization(
    val id: String,
    val is_deleted:Boolean,
    val created_at:String?,
    val updated:String?,
    val title: String?,
    val doctor: String?
)
