package com.example.doctour.data.repository

import com.example.doctour.data.base.BaseRepository
import com.example.doctour.data.local.DoctourDao
import com.example.doctour.data.mapper.toDoctour
import com.example.doctour.data.mapper.toEntity
import com.example.doctour.domain.model.Doctour
import com.example.doctour.domain.repository.DoctourRepository
import javax.inject.Inject

class DoctourRepositoryImpl @Inject constructor(
    private val doctourDao: DoctourDao
) : DoctourRepository,
    BaseRepository() {

    override fun createDoctour(doctour: Doctour) = doRequest {
        doctourDao.createNote(doctour.toEntity())
    }

    override fun getAllDoctour() = doRequest {
        doctourDao.getAllDoctour().map {
            it.toDoctour()
        }
    }


    override fun editDoctour(doctour: Doctour) = doRequest {
        doctourDao.editDoctour(doctour.toEntity())
    }

    override fun deleteDoctour(doctour: Doctour) = doRequest {
        doctourDao.deleteDoctour(doctour.toEntity())
    }
}