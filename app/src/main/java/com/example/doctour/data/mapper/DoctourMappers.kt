package com.example.doctour.data.mapper

import com.example.doctour.data.model.DoctourEntity
import com.example.doctour.domain.model.Doctour

fun Doctour.toEntity() = DoctourEntity(
    id, tittle, description
)

fun DoctourEntity.toDoctour() = Doctour(
    id, tittle, description
)