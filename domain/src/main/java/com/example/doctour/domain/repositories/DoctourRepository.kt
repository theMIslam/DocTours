package com.example.doctour.domain.repositories

import com.example.doctour.domain.core.RemoteWrapper
import com.example.doctour.domain.model.local.DoctourLocal
import kotlinx.coroutines.flow.Flow

interface DoctourRepository {
    fun fetchDoctour(): RemoteWrapper<DoctourLocal>
    fun getDoctour(): Flow<List<DoctourLocal>>
}