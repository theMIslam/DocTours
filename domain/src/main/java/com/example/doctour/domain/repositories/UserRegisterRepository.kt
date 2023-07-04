package com.example.doctour.domain.repositories

import com.example.doctour.domain.model.UserRegister
import com.example.doctour.domain.utils.Either
import com.example.doctour.domain.utils.NetworkError
import com.example.doctour.domain.utils.Resource
import kotlinx.coroutines.flow.Flow

interface UserRegisterRepository {

    fun postRegister(
         phone_number: String?,
         fullname: String?,
         gender: String?,
         birthday: String?,
         password: String?
    ):Flow<Either<String,UserRegister>>
}