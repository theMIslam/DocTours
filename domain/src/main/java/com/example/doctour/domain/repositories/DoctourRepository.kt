package com.example.doctour.domain.repositories

import com.example.doctour.domain.utils.RemoteWrapper
import com.example.doctour.domain.model.local.Doctour
import kotlinx.coroutines.flow.Flow

interface DoctourRepository {
    fun fetchDoctour(): RemoteWrapper<Doctour>
    fun getDoctour(): Flow<List<Doctour>>
}