package com.example.doctour.presentation.model.speciality

import com.example.doctour.base.IBaseDiffModel

data class SpecializationUI(
    override val id: String,
    val is_deleted:Boolean,
    val created_at:String?,
    val updated:String?,
    val title: String?,
    val doctor: String?
): IBaseDiffModel<String>
