package com.example.doctour.domain.usecase

import com.example.doctour.domain.repository.DoctourRepository
import javax.inject.Inject

class GetAllDoctourUseCase @Inject constructor(private val doctourRepository: DoctourRepository) {

    fun getAllDoctour() = doctourRepository.getAllDoctour()
}