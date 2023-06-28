package com.example.doctour.model

import com.example.doctour.base.IBaseDiffModel
import com.example.doctour.domain.model.Service

data class ServiceUi(
    val description: String,
    override val id: Int,
    val name: String,
    val price: Int,
    val subservice_service: List<SubServiceUi>
):IBaseDiffModel<Int>

fun Service.toServiceUi()=ServiceUi(
    description, id, name, price, subservice_service.map { it.toSubUi() }
)
