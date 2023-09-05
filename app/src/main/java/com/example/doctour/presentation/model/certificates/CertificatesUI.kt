package com.example.doctour.presentation.model.certificates

import com.example.doctour.base.IBaseDiffModel

data class CertificatesUI(
    override val id: Int,
    val is_deleted: Boolean,
    val created_at: String?,
    val updated_at: String?,
    val title: String?,
    val year: String?,
    val doctor: String?
) : IBaseDiffModel<Int>
