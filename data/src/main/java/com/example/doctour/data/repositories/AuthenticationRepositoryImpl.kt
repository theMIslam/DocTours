package com.example.doctour.data.repositories

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
    private val authenticationApiService: UserRegisterApiService
) {
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