package com.example.doctour.model

import com.example.doctour.base.IBaseDiffModel
import com.example.doctour.domain.model.Specialization

data class SpecializationUI(
    override val id:Int,
    val title:String,
    val doctor:Int
): IBaseDiffModel<Int>

fun Specialization.toSpecializationUi() =SpecializationUI(
    id, title, doctor
)
