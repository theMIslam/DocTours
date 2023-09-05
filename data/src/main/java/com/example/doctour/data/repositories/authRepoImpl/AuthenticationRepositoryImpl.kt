package com.example.doctour.data.repositories.authRepoImpl

import com.example.doctour.data.base.BaseRepository
import com.example.doctour.data.model.toPasswordResetNewPasswordDt
import com.example.doctour.data.model.toPasswordResetSearchUserDt
import com.example.doctour.data.model.toPasswordResetTokenDt
import com.example.doctour.data.model.toTokenRefreshBodyDt
import com.example.doctour.data.model.toUserConfirmDt
import com.example.doctour.data.model.toUserLoginDt
import com.example.doctour.data.model.toUserRegisterDt
import com.example.doctour.data.remote.apiservices.AuthenticationApiService
import com.example.doctour.domain.model.password.resetNew.PasswordResetNewPassword
import com.example.doctour.domain.model.password.resetSearch.PasswordResetSearchUser
import com.example.doctour.domain.model.password.resetToken.PasswordResetToken
import com.example.doctour.domain.model.profile.Profile
import com.example.doctour.domain.model.TokenRefresh
import com.example.doctour.domain.model.TokenRefreshBody
import com.example.doctour.domain.model.confirm.UserConfirm
import com.example.doctour.domain.model.UserLogin
import com.example.doctour.domain.model.UserRegistration
import com.example.doctour.domain.repositories.AuthenticationRepository
import com.example.doctour.domain.utils.Either
import com.example.doctour.domain.utils.NetworkError
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor(
    private val authenticationApiService: AuthenticationApiService
) :AuthenticationRepository,BaseRepository (){

    override fun deleteUserProfileById(id: String): Flow<Either<String, Unit>>
    = makeNetworkRequest { authenticationApiService.deleteUserProfileById(id) }

    override fun getUserProfileByID(id: String): Flow<Either<NetworkError, Profile>>
    = doNetworkRequestWithMapping { authenticationApiService.getUserProfileByID(id) }

    override fun resetPasswordCode(data: PasswordResetToken): Flow<Either<NetworkError, PasswordResetToken>>
    = doNetworkRequestWithMapping { authenticationApiService.resetPasswordCode(data.toPasswordResetTokenDt()) }

    override fun resetNewPassword(
        data: PasswordResetNewPassword,
        code: String
    ): Flow<Either<NetworkError, PasswordResetNewPassword>>
    = doNetworkRequestWithMapping { authenticationApiService.resetNewPassword(
        data.toPasswordResetNewPasswordDt(),
        code) }

    override fun searchUserAndCreateCode(data: PasswordResetSearchUser): Flow<Either<NetworkError, PasswordResetSearchUser>>
    = doNetworkRequestWithMapping { authenticationApiService.searchUserAndCreateCode(data.toPasswordResetSearchUserDt()) }

    override fun tokenRefresh(data: TokenRefreshBody): Flow<Either<NetworkError, TokenRefresh>>
    = doNetworkRequestWithMapping { authenticationApiService.tokenRefresh(data.toTokenRefreshBodyDt()) }

    override fun confirmUser(data: UserConfirm): Flow<Either<NetworkError, UserConfirm>>
    = doNetworkRequestWithMapping { authenticationApiService.userConfirm(data.toUserConfirmDt())}

    override fun logOut(): Flow<Either<String, Unit>> =
        makeNetworkRequest { authenticationApiService.userLogOut()}

    override fun postRegister(data:UserRegistration)
    = doNetworkRequestWithMapping { authenticationApiService.registerUser(data.toUserRegisterDt())}

    override fun postLogin(data: UserLogin): Flow<Either<NetworkError, UserLogin>>
            = doNetworkRequestWithMapping { authenticationApiService.userLogin(data.toUserLoginDt()) }

    //    fun signUp (
//        username: String,
//        number: String,
//        password: String,
//        password_again: String
//    ) = makeNetworkRequest {
//        userRegisterApiService.signUp(
//            SignUpDto(
//                username,
//                number,
//                password,
//                password_again
//            )
//        )
//    }

//    protected fun <T> makeNetworkRequest(
//        gatherIfSucceed: ((T) -> Unit)? = null,
//        request: suspend () -> T
//    ) =
//        flow<Either<String, T>> {
//            request().also {
//                gatherIfSucceed?.invoke(it)
//                emit(Either.Right(value = it))
//            }
//        }.flowOn(Dispatchers.IO).catch { exception ->
//            emit(Either.Left(value = exception.localizedMessage ?: "Error Occurred!"))
//        }
}