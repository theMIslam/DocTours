package com.example.doctour.domain.usecases.local

import com.example.doctour.domain.model.Doctor
import com.example.doctour.domain.repositories.LocalRepository
import javax.inject.Inject

class CreateFavDoctorUseCase (
    private val localRepository: LocalRepository
){

    fun createFavoriteDoctors(doctor: Doctor) = localRepository.createFavDoctors(doctor)
}