package com.example.doctour.presentation.ui.fragments.authAndReg.signIn

import androidx.lifecycle.viewModelScope
import com.example.doctour.base.BaseViewModel
import com.example.doctour.data.model.TokenRefreshDt
import com.example.doctour.data.model.UserLoginDt
import com.example.doctour.data.model.UserRegisterDt
import com.example.doctour.data.remote.dtos.auth.SignInResultDto
import com.example.doctour.data.repositories.AuthenticationRepositoryImpl
import com.example.doctour.domain.model.UserLogin
import com.example.doctour.domain.usecases.SignInUseCase
import com.example.doctour.presentation.model.TokenRefreshUI
import com.example.doctour.presentation.model.UserLoginUi
import com.example.doctour.presentation.model.toTokenRefreshUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val authenticationRepository: AuthenticationRepositoryImpl,
    private val signInUseCase: SignInUseCase
) : BaseViewModel() {

    private val _signIn = MutableUIStateFlow<TokenRefreshUI>()
    val signIn = _signIn.asStateFlow()

    fun signIn (phone_number:String,
                password:String)
    = signInUseCase(phone_number, password).collectRequest(_signIn){
        it.toTokenRefreshUI()
    }

//    private val _signIn = mutableUiStateFlow<TokenRefreshDt>()
//        //mutableUiStateFlow<UserLoginDt>()
//    val signIn = _signIn.asStateFlow()

//    fun logInUser(
//        phone_number: String?,
//        password: String?
//    ) =authenticationRepository.logInUser(
//        phone_number, password
//    ).gatherRequest(_signIn)
//
//    private val _signInState = MutableUIStateFlow<SignInResultDto>()
//    val signInState = _signInState.asStateFlow()
}