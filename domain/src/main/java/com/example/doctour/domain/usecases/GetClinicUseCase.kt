package com.example.doctour.domain.usecases

import com.example.doctour.domain.repositories.RemoteDoctorRepository
import javax.inject.Inject

class GetClinicUseCase @Inject constructor(
    private val remoteDoctorRepository: RemoteDoctorRepository
){
    operator fun invoke()= remoteDoctorRepository.getClinics()

}