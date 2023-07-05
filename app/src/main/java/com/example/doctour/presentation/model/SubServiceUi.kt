package com.example.doctour.presentation.model

import com.example.doctour.base.IBaseDiffModel
import com.example.doctour.domain.model.SubService

data class SubServiceUi(
    override val id: String,
    val name: String?,
    val slug: String?,
    val price: Int?,
    val count_clinic: String?,
    val service: String?,
    val clinic: List<ClinicsUi>? = emptyList()
) : IBaseDiffModel<String>

fun SubService.toSubUi() = SubServiceUi(
    id = id,
    name = name,
    slug = slug,
    price = price,
    count_clinic = count_clinic,
    service = service,
    clinic?.map { it.toClinicsUi() }
)

