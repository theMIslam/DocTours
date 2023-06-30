package com.example.doctour.model

import com.example.doctour.base.IBaseDiffModel
import com.example.doctour.domain.model.Clinics
import com.example.doctour.domain.model.SubService
import com.example.doctour.presentation.model.ClinicsUi
import com.example.doctour.presentation.model.toClinicsUi

data class SubServiceUi(
    override val id:Int,
    val name:String?,
    val price:Int?,
    val count_clinic:String?,
    val service:Int?,
    val clinic:List<ClinicsUi>?= emptyList()
):IBaseDiffModel<Int>

fun SubService.toSubUi()=SubServiceUi(
    id=id,name=name,price=price,count_clinic=count_clinic, service=service, clinic?.map { it.toClinicsUi() }
)

