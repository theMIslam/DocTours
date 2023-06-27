package com.example.doctour.data.base

data class BaseResponse <T>(
    val count:Int,
    val next:String,
    val previous:String,
    val results:List<T>
)
