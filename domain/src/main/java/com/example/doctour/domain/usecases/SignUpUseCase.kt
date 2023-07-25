package com.example.doctour.domain.usecases

import com.example.doctour.domain.model.UserRegistration
import com.example.doctour.domain.repositories.AuthenticationRepository
import javax.inject.Inject

class SignUpUseCase @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) {
    operator fun invoke(data: UserRegistration)
    = authenticationRepository.postRegister(data)
}