package com.example.doctour.domain.usecases

import com.example.doctour.domain.repositories.RemoteDoctorRepository
import javax.inject.Inject

class GetAllDoctorsUseCase @Inject constructor(
    private val remoteDoctorRepository: RemoteDoctorRepository
) {
    operator fun invoke(
        specialties: String?,
        clinic: String?,
        categoryService: String?,
        city: String?,
        search: String?,
        ordering: String?
    )= remoteDoctorRepository.getAllDoctors(specialties, clinic, categoryService, city, search, ordering)

}