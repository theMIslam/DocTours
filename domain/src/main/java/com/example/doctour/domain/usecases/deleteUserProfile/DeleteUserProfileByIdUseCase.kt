package com.example.doctour.domain.usecases.deleteUserProfile

import com.example.doctour.domain.repositories.AuthenticationRepository
import javax.inject.Inject

class DeleteUserProfileByIdUseCase @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) {

    operator fun  invoke(id:String) = authenticationRepository.deleteUserProfileById(id)
}