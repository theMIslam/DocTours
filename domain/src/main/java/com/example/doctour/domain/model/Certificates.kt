package com.example.doctour.domain.model

data class Certificates(
    val id: Int,
    val is_deleted:Boolean,
    val created_at:String?,
    val updated_at:String?,
    val title: String?,
    val year: String?,
    val doctor: String?
)
