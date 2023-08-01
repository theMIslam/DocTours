package com.example.doctour.domain.usecases

import com.example.doctour.domain.model.PasswordResetSearchUser
import com.example.doctour.domain.repositories.AuthenticationRepository
import javax.inject.Inject

class SearchUserAndCreateCodeUseCase @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) {
    operator fun invoke (data:PasswordResetSearchUser) = authenticationRepository.searchUserAndCreateCode(data)

}