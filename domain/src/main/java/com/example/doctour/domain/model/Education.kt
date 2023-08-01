package com.example.doctour.domain.model

data class Education(
    val id: String,
    val is_deleted:Boolean,
    val created_at:String?,
    val updated_at:String?,
    val title: String?,
    val specialization: String?,
    val year: String?,
    val doctor: String?
)
