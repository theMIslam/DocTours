package com.example.doctour.domain.usecases.logout

import com.example.doctour.domain.repositories.AuthenticationRepository
import com.example.doctour.domain.repositories.DoctourRepository
import javax.inject.Inject

class LogOutUseCase @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) {

    operator fun invoke () = authenticationRepository.logOut()

}