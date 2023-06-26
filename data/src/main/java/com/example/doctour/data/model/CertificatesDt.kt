package com.example.doctour.data.model

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.Certificates

data class CertificatesDt(
    val id: Int,
    val year: String,
    val title: String,
    val doctor: Int
) : DataMapper<Certificates> {
    override fun mapToDomain() = Certificates(
        id,
        year,
        title,
        doctor
    )

}
