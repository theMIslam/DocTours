package com.example.doctour.domain.usecases

import com.example.doctour.domain.model.UserRegister
import com.example.doctour.domain.repositories.UserRegisterRepository
import javax.inject.Inject

class UserRegisterUseCases @Inject constructor(
    private val userRegisterRepository: UserRegisterRepository
) {
    operator fun invoke(
        phone_number: String?,
        fullname: String?,
        gender: String?,
        birthday: String?,
        password: String?
    ) = userRegisterRepository.postRegister(phone_number, fullname, gender, birthday, password)
}