package com.example.doctour.domain.usecases.createUserProfile

import com.example.doctour.domain.repositories.AuthenticationRepository
import javax.inject.Inject

class GetUserProfileByIDUseCase @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) {

    operator fun invoke(id:String) = authenticationRepository.getUserProfileByID(id)
}