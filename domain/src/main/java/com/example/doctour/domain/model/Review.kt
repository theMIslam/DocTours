package com.example.doctour.domain.model

data class Review(
    val id:Int,
    val text:String,
    val stars:Int,
    val doctor :List<Int>
)
