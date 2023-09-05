package com.example.doctour.domain.model.experience

data class Experience(
    val id: String,
    val is_deleted:Boolean,
    val created_at:String?,
    val updated_at:String?,
    val title: String?,
    val year: String?,
    val doctor: String?
)
