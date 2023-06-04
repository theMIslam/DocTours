package com.example.doctour.domain.usecases.doctour

import com.example.doctour.domain.repositories.DoctourRepository
import javax.inject.Inject

class FetchDoctourUseCase @Inject constructor(
    private val repository: DoctourRepository
) {
    operator fun invoke() = repository.fetchDoctour()
}