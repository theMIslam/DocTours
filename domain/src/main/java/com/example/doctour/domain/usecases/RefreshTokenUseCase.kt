package com.example.doctour.domain.usecases

import com.example.doctour.domain.model.TokenRefreshBody
import com.example.doctour.domain.repositories.AuthenticationRepository
import javax.inject.Inject

class RefreshTokenUseCase @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) {

    operator fun invoke (data:TokenRefreshBody) = authenticationRepository.tokenRefresh(data)
}