package com.example.doctour.data.repositories

import com.example.doctour.data.model.UserLoginDt
import com.example.doctour.data.model.UserRegisterDt
import com.example.doctour.data.remote.apiservices.DoctourApiService
import com.example.doctour.data.remote.apiservices.UserRegisterApiService
import com.example.doctour.data.remote.dtos.auth.SignInDto
import com.example.doctour.data.remote.dtos.auth.SignUpDto
import com.example.doctour.domain.utils.Either
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class AuthenticationRepositoryImpl @Inject constructor(
    private val authenticationApiService: UserRegisterApiService,
    private val doctourApiService: DoctourApiService
) {

     fun logInUser(
         phone_number: String?,
         password: String?
     )=makeNetworkRequest {
         doctourApiService.postLogin(
             UserLoginDt(
             phone_number, password
         ))
     }
    fun registerUser(
        phone_number: String?,
        fullname: String?,
        gender: String?,
        birthday: String?,
        password: String?
    ) = makeNetworkRequest {
        doctourApiService.postRegister(
            UserRegisterDt(
                phone_number, fullname, gender, birthday, password
            )
        )
    }

    fun signUp(
        username: String,
        number: String,
        password: String,
        password_again: String
    ) = makeNetworkRequest {
        authenticationApiService.signUp(
            SignUpDto(
                username,
                number,
                password,
                password_again
            )
        )
    }

    protected fun <T> makeNetworkRequest(
        gatherIfSucceed: ((T) -> Unit)? = null,
        request: suspend () -> T
    ) =
        flow<Either<String, T>> {
            request().also {
                gatherIfSucceed?.invoke(it)
                emit(Either.Right(value = it))
            }
        }.flowOn(Dispatchers.IO).catch { exception ->
            emit(Either.Left(value = exception.localizedMessage ?: "Error Occurred!"))
        }

  suspend  fun signIn(username: String, password: String) =
        authenticationApiService.login(SignInDto(username, password))
}