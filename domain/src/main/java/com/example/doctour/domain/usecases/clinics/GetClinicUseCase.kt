package com.example.doctour.domain.usecases.clinics

import com.example.doctour.domain.repositories.DoctourRepository
import javax.inject.Inject

class GetClinicUseCase @Inject constructor(
    private val doctorRepository: DoctourRepository
){
    operator fun invoke(
        search: String,
        subServiceClinic: String,
        city: String
    )= doctorRepository.getClinics(
        search,
        subServiceClinic,
        city
    )
}