package com.example.doctour.domain.usecases.writeReviews

import com.example.doctour.domain.model.reviews.ReviewBody
import com.example.doctour.domain.repositories.DoctourRepository
import javax.inject.Inject

class WriteReviewUseCase @Inject constructor(
    private val doctorRepository: DoctourRepository
) {
    operator fun invoke(data: ReviewBody)
    = doctorRepository.postReviews(data)
}