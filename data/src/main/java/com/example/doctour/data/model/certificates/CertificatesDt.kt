package com.example.doctour.data.model.certificates

import com.example.doctour.data.utils.DataMapper
import com.example.doctour.domain.model.certificates.Certificates

data class CertificatesDt(
    val id: Int,
    val is_deleted:Boolean,
    val created_at:String?,
    val updated_at:String?,
    val title: String?,
    val year: String?,
    val doctor: String?
) : DataMapper<Certificates> {
    override fun mapToDomain() = Certificates(
        id,
        is_deleted,
        created_at,
        updated_at,
        title,
        year,
        doctor
    )
}
