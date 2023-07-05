package com.example.doctour.presentation.model

import com.example.doctour.base.IBaseDiffModel
import com.example.doctour.domain.model.Service

data class ServiceUi(
    val description: String?,
    override val id: String,
    val name: String?,
    val slug:String?,
    val price: Int?,
    val subservice_service: List<SubServiceUi>?= emptyList()
):IBaseDiffModel<String>

fun Service.toServiceUi()= ServiceUi(
    description=description,
    id=id,
    name=name,
    slug = slug,
    price=price,
    subservice_service?.map { it.toSubUi() }
)
