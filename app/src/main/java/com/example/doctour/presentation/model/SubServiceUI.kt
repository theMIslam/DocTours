package com.example.doctour.presentation.model

import com.example.doctour.base.IBaseDiffModel
import com.example.doctour.domain.model.SubService

data class SubServiceUI(
    override val id:Int,
    val name:String?,
    val slug:String?,
    val count_clinic:String?,
    val service:Int?,
    val clinic:List<ClinicUI> ?= emptyList()
): IBaseDiffModel<Int>

fun SubService.toSubServiceUI()=SubServiceUI(
    id, name, slug, count_clinic, service,clinic?.map { it.toClinicUI() }
)
