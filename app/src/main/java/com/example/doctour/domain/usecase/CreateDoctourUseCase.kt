package com.example.doctour.domain.usecase

import com.example.doctour.domain.model.Doctour
import com.example.doctour.domain.repository.DoctourRepository
import javax.inject.Inject

class CreateDoctourUseCase @Inject constructor(
    private val doctourRepository: DoctourRepository
) {

    fun createDoctour(doctour: Doctour) = doctourRepository.createDoctour(doctour)
}