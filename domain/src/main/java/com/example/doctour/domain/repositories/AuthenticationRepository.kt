package com.example.doctour.domain.repositories

import com.example.doctour.domain.model.PasswordResetNewPassword
import com.example.doctour.domain.model.PasswordResetSearchUser
import com.example.doctour.domain.model.PasswordResetToken
import com.example.doctour.domain.model.Profile
import com.example.doctour.domain.model.TokenRefresh
import com.example.doctour.domain.model.TokenRefreshBody
import com.example.doctour.domain.model.UserConfirm
import com.example.doctour.domain.model.UserLogin
import com.example.doctour.domain.model.UserRegistration
import com.example.doctour.domain.utils.Either
import com.example.doctour.domain.utils.NetworkError
import kotlinx.coroutines.flow.Flow

interface AuthenticationRepository {

    fun deleteUserProfileById(id:String):Flow<Either<String,Unit>>

    fun getUserProfileByID(id:String):Flow<Either<NetworkError,Profile>>

    fun resetPasswordCode(data:PasswordResetToken):Flow<Either<NetworkError,PasswordResetToken>>

    fun resetNewPassword( data :PasswordResetNewPassword,code :String):Flow<Either<NetworkError,PasswordResetNewPassword>>

    fun searchUserAndCreateCode(data:PasswordResetSearchUser):Flow<Either<NetworkError,PasswordResetSearchUser>>

    fun tokenRefresh(data:TokenRefreshBody):Flow<Either<NetworkError,TokenRefresh>>

    fun postRegister(data:UserRegistration): Flow<Either<NetworkError, UserRegistration>>

    fun postLogin(data: UserLogin): Flow<Either<NetworkError,UserLogin>>

    fun confirmUser(data: UserConfirm): Flow<Either<NetworkError, UserConfirm>>

    fun logOut(): Flow<Either<String, Unit>>

}