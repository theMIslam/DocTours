package com.example.doctour.domain.model

data class WhatsappSend(
    val doctor:Int,
    val surname:String,
    val firstname:String,
    val lastname:String,
    val gender:String,
    val age:List<Int>,
    val number:String,
    val email:String,
    val problem:String
)
