package com.example.doctour.domain.usecases.doctors

import com.example.doctour.domain.repositories.DoctourRepository
import javax.inject.Inject

class GetDoctorsUseCase @Inject constructor(
    private val doctorRepository: DoctourRepository
) {
    operator fun invoke(
        search: String?,
        ordering: String?,
        city: String?,
        categoryService: String?,
        specialties: String?
    )= doctorRepository.getDoctors(
        search,
        ordering,
        city,
        categoryService,
        specialties)

}