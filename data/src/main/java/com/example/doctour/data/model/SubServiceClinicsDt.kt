package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.SubServiceClinics

data class SubServiceClinicsDt(
    val clinic:List<ClinicDt>?= emptyList()
):DataMapper<SubServiceClinics>{
    override fun mapToDomain()= SubServiceClinics(
        clinic?.map { it.mapToDomain() }
    )
}
