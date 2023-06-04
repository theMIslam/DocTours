package com.example.doctour.domain.usecases.doctourpaging

import com.example.doctour.domain.repositories.DoctourRepository
import javax.inject.Inject

class FetchDoctourPagingUseCase @Inject constructor(
    private val repository: DoctourRepository
) {
    operator fun invoke() = repository.fetchDoctourPaging()
}