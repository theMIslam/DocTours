package com.example.doctour.presentation.model

import com.example.doctour.base.IBaseDiffModel
import com.example.doctour.domain.model.Specialty

data class SpecialtyUI(
    override val id: Int,
    val slug:String,
    val name: String?,
    val doctors_count:String?
): IBaseDiffModel<Int>

fun Specialty.toSpecialtyUI()=SpecialtyUI(
    id, slug, name, doctors_count
)