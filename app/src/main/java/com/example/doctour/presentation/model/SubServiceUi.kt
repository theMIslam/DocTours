package com.example.doctour.presentation.model

import com.example.doctour.base.IBaseDiffModel
import com.example.doctour.domain.model.SubService

data class SubServiceUi(
    override val id:Int,
    val name:String,
    val price:Int,
    val count_clinic:String,
    val service:Int,
    val clinic: List<ClinicsUi>
):IBaseDiffModel<Int>

fun SubService.toSubUi()= SubServiceUi(
    id,name,price,count_clinic, service, clinic.map { it.toClinicsUi() }
)

