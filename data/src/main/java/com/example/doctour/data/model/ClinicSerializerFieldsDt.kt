package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.clinics.ClinicSerializerFields

data class ClinicSerializerFieldsDt(
    val id:String,
    val title:String
):DataMapper<ClinicSerializerFields>{
    override fun mapToDomain()= ClinicSerializerFields(
        id, title
    )
}
