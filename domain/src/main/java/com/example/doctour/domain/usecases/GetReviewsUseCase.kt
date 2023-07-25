package com.example.doctour.domain.usecases

import com.example.doctour.domain.repositories.DoctourRepository
import javax.inject.Inject

class GetReviewsUseCase @Inject constructor(
    private val doctorRepository: DoctourRepository
) {
    operator fun invoke()
    = doctorRepository.getReviews()
}