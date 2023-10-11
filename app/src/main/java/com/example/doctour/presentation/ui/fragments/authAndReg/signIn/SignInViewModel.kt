package com.example.doctour.presentation.ui.fragments.authAndReg.signIn

import com.example.doctour.base.BaseViewModel
import com.example.doctour.data.model.tokenRefresh.SignInResultDto
import com.example.doctour.data.model.tokenRefresh.TokenRefreshDt
import com.example.doctour.data.repositories.authRepoImpl.AuthenticationRepositoryImpl
import com.example.doctour.domain.model.TokenRefresh
import com.example.doctour.domain.model.UserLogin
import com.example.doctour.domain.usecases.RefreshTokenUseCase
import com.example.doctour.domain.usecases.SignInUseCase
import com.example.doctour.presentation.model.login.UserLoginUI
import com.example.doctour.presentation.model.login.toUserLoginUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val authenticationRepository: AuthenticationRepositoryImpl,
    private val signInUseCase: SignInUseCase,
    private val refreshTokenUseCase: RefreshTokenUseCase
) : BaseViewModel() {

    private val _signIn = MutableUIStateFlow<UserLoginUI>()
    val signIn = _signIn.asStateFlow()

    private val _tokenRefresh = MutableUIStateFlow<TokenRefresh>()
    val tokenRefresh = _tokenRefresh.asStateFlow()

    fun signIn (phone_number:String,
                password:String)
    = signInUseCase(
        UserLogin(
        phone_number,
        password,
    )).collectNetworkRequest(_signIn){
        it.toUserLoginUI()
    }


    collectRequest(_signIn){
        it.toTokenRefreshUI()
    }

    private val _signIn = mutableUiStateFlow<TokenRefreshDt>()
        //mutableUiStateFlow<UserLoginDt>()
    val signIn = _signIn.asStateFlow()

    fun logInUser(
        phone_number: String?,
        password: String?
    ) =authenticationRepository.logInUser(
        phone_number, password
    ).gatherRequest(_signIn)

    private val _signInState = MutableUIStateFlow<SignInResultDto>()
    val signInState = _signInState.asStateFlow()
}