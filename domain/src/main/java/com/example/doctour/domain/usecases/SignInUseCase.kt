package com.example.doctour.domain.usecases

import com.example.doctour.domain.model.UserLogin
import com.example.doctour.domain.repositories.AuthenticationRepository
import com.example.doctour.domain.repositories.DoctourRepository
import javax.inject.Inject

class SignInUseCase @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) {

    operator fun invoke (data:UserLogin)
    = authenticationRepository.postLogin(data)
}