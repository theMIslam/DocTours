package com.example.doctour.domain.usecase

import com.example.doctour.domain.model.Doctour
import com.example.doctour.domain.repository.DoctourRepository
import javax.inject.Inject

class DeleteDoctourUseCase @Inject constructor(private val doctourRepository: DoctourRepository) {

    fun deleteDoctour(doctour: Doctour) = doctourRepository.deleteDoctour(doctour)
}