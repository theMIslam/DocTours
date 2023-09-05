package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.whatsappSend.WhatsappSend

data class WhatsappSendDt(
    val doctor: String,
    val fullname:String,
    val birthday:String,
    val gender: String,
    val phone_number:String
) : DataMapper<WhatsappSend> {
    override fun mapToDomain() = WhatsappSend(
        doctor, fullname, birthday, gender, phone_number
    )
}
