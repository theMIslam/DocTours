package com.example.doctour.presentation.model.profile

import com.example.doctour.base.IBaseDiffModel
import com.example.doctour.domain.model.profile.Profile

data class ProfileUI(
    override val id: String,
    val fullname: String,
    val phone_number: String,
    val birthday: String,
    val gender: String
): IBaseDiffModel<String>

fun Profile.toProfileUI()= ProfileUI(
    id, fullname, phone_number, birthday, gender
)