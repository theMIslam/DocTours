package com.example.doctour.domain.usecases

import com.example.doctour.domain.model.UserLogin
import com.example.doctour.domain.repositories.RemoteDoctorRepository
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val remoteDoctorRepository: RemoteDoctorRepository
) {

    operator fun invoke (phone_number:String,password:String) = remoteDoctorRepository.postLogin(phone_number, password)
}