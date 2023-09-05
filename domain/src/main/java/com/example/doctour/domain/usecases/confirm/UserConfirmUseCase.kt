package com.example.doctour.domain.usecases.confirm

import com.example.doctour.domain.model.confirm.UserConfirm
import com.example.doctour.domain.repositories.AuthenticationRepository
import javax.inject.Inject

class UserConfirmUseCase @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) {

    operator fun  invoke (data: UserConfirm) = authenticationRepository.confirmUser(data)
}