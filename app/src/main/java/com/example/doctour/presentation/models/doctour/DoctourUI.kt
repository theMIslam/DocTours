package com.example.doctour.presentation.models.doctour

import com.example.doctour.domain.model.Doctour
import com.example.doctour.presentation.base.IBaseDiffModel


data class DoctourUI(
    override val id: Long,
    val bar: String
) : IBaseDiffModel<Long>

fun Doctour.toUI() = DoctourUI(id, bar)