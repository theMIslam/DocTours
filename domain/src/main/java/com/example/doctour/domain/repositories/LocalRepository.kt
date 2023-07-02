package com.example.doctour.domain.repositories

import com.example.doctour.domain.model.Doctor
import com.example.doctour.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface LocalRepository {
    fun createFavDoctors(doctor: Doctor): Flow<Resource<Unit>>
    fun getAllFavDoctors(): Flow<Resource<List<Doctor>>>
    fun deleteFavDoctors(doctor: Doctor): Flow<Resource<Unit>>
}