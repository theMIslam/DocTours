package com.example.doctour.domain.usecase

import com.example.doctour.domain.model.Doctour
import com.example.doctour.domain.repository.DoctourRepository
import javax.inject.Inject

class EditDoctourUseCase @Inject constructor(
    private val doctourRepository: DoctourRepository,
    private val a: String,
) {

    fun editDoctour(doctour: Doctour) = doctourRepository.editDoctour(doctour)
}
