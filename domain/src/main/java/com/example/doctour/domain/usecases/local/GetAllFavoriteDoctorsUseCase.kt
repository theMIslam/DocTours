package com.example.doctour.domain.usecases.local

import com.example.doctour.domain.repositories.LocalRepository
import javax.inject.Inject

class GetAllFavoriteDoctorsUseCase(
    private val localRepository: LocalRepository
) {
    fun getaAllFavDoctors() = localRepository.getAllFavDoctors()
}