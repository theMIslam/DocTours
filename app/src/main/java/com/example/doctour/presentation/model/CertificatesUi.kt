package com.example.doctour.presentation.model

import com.example.doctour.base.IBaseDiffModel
import com.example.doctour.domain.model.Certificates

data class CertificatesUi(
    override val id: Int,
    val year: String,
    val title: String,
    val doctor: Int
):IBaseDiffModel<Int>
fun Certificates.toCertificatesUi()= CertificatesUi(
    id, year, title, doctor
)
