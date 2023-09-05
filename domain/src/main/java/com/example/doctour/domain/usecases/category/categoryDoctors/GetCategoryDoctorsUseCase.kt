package com.example.doctour.domain.usecases.category.categoryDoctors

import com.example.doctour.domain.repositories.DoctourRepository
import javax.inject.Inject

class GetCategoryDoctorsUseCase @Inject constructor(
    private val doctorRepository:DoctourRepository
) {
    operator fun invoke(search:String)
    = doctorRepository.getSpeciality(search)
}