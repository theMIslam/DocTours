package com.example.doctour.presentation.ui.fragments.authAndReg.signUpimport com.example.doctour.base.BaseViewModelimport com.example.doctour.data.model.UserRegisterDtimport com.example.doctour.data.repositories.AuthenticationRepositoryImplimport dagger.hilt.android.lifecycle.HiltViewModelimport kotlinx.coroutines.flow.asStateFlowimport javax.inject.Inject@HiltViewModelclass SignUpViewModel @Inject constructor(    private val authenticationRepositoryImpl: AuthenticationRepositoryImpl) : BaseViewModel() {    private val _signUpState = mutableUiStateFlow<UserRegisterDt>()    val signUpState = _signUpState.asStateFlow()    fun registerUser(        phone_number: String?,        fullname: String?,        gender: String?,        birthday: String?,        password: String?    ) = authenticationRepositoryImpl.registerUser(        phone_number, fullname, gender, birthday, password    ).gatherRequest(_signUpState)//    fun signUp(//        username: String,//        number: String,//        password: String,//        password_again: String//    ) = authenticationRepositoryImpl.signUp(//        username,//        number,//        password,//        password_again//    ).gatherRequest(_signUpState)}