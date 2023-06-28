package com.example.doctour.domain.model

data class Review(
    val doctor: Int,
    val id: Int,
    val stars: Int,
    val text: String
)
