package com.example.doctour.domain.usecases.local

import com.example.doctour.domain.model.Doctor
import com.example.doctour.domain.repositories.LocalRepository
import javax.inject.Inject

class DeleteFavDoctorsUseCase (
    private val localRepository: LocalRepository
) {
    fun deleteFavDoctors(doctor: Doctor) = localRepository.deleteFavDoctors(doctor)
}