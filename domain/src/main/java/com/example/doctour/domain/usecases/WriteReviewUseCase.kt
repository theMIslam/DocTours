package com.example.doctour.domain.usecases

import com.example.doctour.domain.model.Review
import com.example.doctour.domain.model.WriteReview
import com.example.doctour.domain.repositories.RemoteDoctorRepository
import javax.inject.Inject

class WriteReviewUseCase @Inject constructor(
    private val remoteDoctorRepository: RemoteDoctorRepository
) {
    operator fun invoke(data:WriteReview) = remoteDoctorRepository.writeReview(data)
}