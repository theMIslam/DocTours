package com.example.doctour.presentation.ui.fragments.authAndReg.signIn

import com.example.doctour.base.BaseViewModel
import com.example.doctour.data.remote.dtos.auth.SignInResultDto
import com.example.doctour.data.repositories.AuthenticationRepositoryImpl
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class   SignInViewModel @Inject constructor (
        private val authenticationRepository: AuthenticationRepositoryImpl
        ): BaseViewModel() {
        private val _signInState = MutableUIStateFlow<SignInResultDto>()
        val signInState = _signInState.asStateFlow()

        fun signIn(username: String, password: String) =
                authenticationRepository.signIn(username, password)
}