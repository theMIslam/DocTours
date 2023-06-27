package com.example.doctour.domain.model

data class UserRegister(
    val email:String,
    val password:String,
    val username:String,
    val surname:String,
    val lastname:String,
    val phone:Int,
    val gender:String,
    val birthday:List<Int>
)
