package com.example.doctour.domain.model

data class WriteReview(
    val text:String,
    val stars:Int,
    val doctor:String,
    val user :Long
)
