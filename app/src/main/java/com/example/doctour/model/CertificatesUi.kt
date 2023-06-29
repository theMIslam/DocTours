package com.example.doctour.model

import com.example.doctour.base.IBaseDiffModel
import com.example.doctour.domain.model.Certificates

data class CertificatesUi(
    override val id: Int,
    val year: String,
    val title: String,
    val doctor: Int
):IBaseDiffModel<Int>
fun Certificates.toCertificatesUi()=CertificatesUi(
    id=id,
    year=year,
    title=title,
    doctor=doctor
)
