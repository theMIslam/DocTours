package com.example.doctour.domain.usecases

import com.example.doctour.domain.repositories.RemoteDoctorRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val remoteDoctorRepository: RemoteDoctorRepository
) {
    operator fun invoke(
        phone_number: String?,
        fullname: String?,
        gender: String?,
        birthday: String?,
        password: String?
    ) = remoteDoctorRepository.postRegister(
        phone_number,
        fullname,
        gender,
        birthday,
        password
    )
}