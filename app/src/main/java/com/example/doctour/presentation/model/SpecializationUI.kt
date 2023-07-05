package com.example.doctour.presentation.model

import com.example.doctour.base.IBaseDiffModel
import com.example.doctour.domain.model.Specialization

data class SpecializationUI(
    override val id:String,
    val title:String?,
    val doctor:Int?
): IBaseDiffModel<String>

fun Specialization.toSpecializationUi() =SpecializationUI(
    id=id, title=title, doctor=doctor
)
