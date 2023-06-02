package com.example.doctour.domain.repository

import com.example.doctour.domain.model.Doctour
import com.example.doctour.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface DoctourRepository {

    fun createDoctour(doctour: Doctour): Flow<Resource<Unit>>

    fun editDoctour(doctour: Doctour): Flow<Resource<Unit>>

    fun getAllDoctour(): Flow<Resource<List<Doctour>>>

    fun deleteDoctour(doctour: Doctour): Flow<Resource<Unit>>
}