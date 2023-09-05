package com.example.doctour.domain.usecases.resetPassword

import com.example.doctour.domain.model.password.resetNew.PasswordResetNewPassword
import com.example.doctour.domain.repositories.AuthenticationRepository
import javax.inject.Inject

class ResetNewPasswordUseCase @Inject constructor(
    private val authenticationRepository: AuthenticationRepository
) {
    operator  fun  invoke (data: PasswordResetNewPassword, code:String)
    = authenticationRepository.resetNewPassword(data,code)
}