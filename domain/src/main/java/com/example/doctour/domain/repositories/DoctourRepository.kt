package com.example.doctour.domain.repositories

import com.example.doctour.domain.core.RemotePagingWrapper
import com.example.doctour.domain.core.RemoteWrapper
import com.example.doctour.domain.model.Doctour
import kotlinx.coroutines.flow.Flow

interface DoctourRepository {

    fun fetchDoctour(): RemoteWrapper<Doctour>

    fun fetchDoctourPaging(): RemotePagingWrapper<Doctour>

    fun getDoctour(): Flow<List<Doctour>>
}