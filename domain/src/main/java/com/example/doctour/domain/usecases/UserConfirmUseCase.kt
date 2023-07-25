package com.example.doctour.domain.usecases

import com.example.doctour.domain.model.UserConfirm
import com.example.doctour.domain.repositories.AuthenticationRepository
import javax.inject.Inject

class UserConfirmUseCase @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) {

    operator fun  invoke (data:UserConfirm) = authenticationRepository.confirmUser(data)
}