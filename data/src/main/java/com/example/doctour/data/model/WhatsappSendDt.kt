package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.WhatsappSend

data class WhatsappSendDt(
    val doctor: Int,
    val surname: String,
    val firstname: String,
    val lastname: String,
    val gender: String,
    val age: List<Int>,
    val number: String,
    val email: String,
    val problem: String
) : DataMapper<WhatsappSend> {
    override fun mapToDomain() = WhatsappSend(
        doctor,
        surname,
        firstname,
        lastname,
        gender,
        age,
        number,
        email,
        problem
    )
}
