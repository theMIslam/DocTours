package com.example.doctour.domain.usecases.resetPassword

import com.example.doctour.domain.model.password.resetToken.PasswordResetToken
import com.example.doctour.domain.repositories.AuthenticationRepository
import javax.inject.Inject

class ResetPasswordCodeUseCase @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) {

    operator fun invoke(data: PasswordResetToken) = authenticationRepository.resetPasswordCode(data)
}