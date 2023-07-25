package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.SpecialitySerializerFields

data class SpecialitySerializerFieldsDt(
    val slug:String,
    val name:String
):DataMapper<SpecialitySerializerFields>{
    override fun mapToDomain()= SpecialitySerializerFields(
        slug, name
    )
}
