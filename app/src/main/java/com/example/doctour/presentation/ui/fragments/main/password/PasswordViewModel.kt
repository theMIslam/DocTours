package com.example.doctour.presentation.ui.fragments.main.password

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.asFlow
import com.example.doctour.base.BaseViewModel
import com.example.doctour.data.model.toPasswordResetNewPasswordDt
import com.example.doctour.domain.model.PasswordResetNewPassword
import com.example.doctour.domain.model.PasswordResetSearchUser
import com.example.doctour.domain.model.PasswordResetToken
import com.example.doctour.domain.model.UserConfirm
import com.example.doctour.domain.usecases.ResetNewPasswordUseCase
import com.example.doctour.domain.usecases.ResetPasswordCodeUseCase
import com.example.doctour.domain.usecases.SearchUserAndCreateCodeUseCase
import com.example.doctour.domain.usecases.UserConfirmUseCase
import com.example.doctour.presentation.model.PasswordResetNewPasswordUI
import com.example.doctour.presentation.model.PasswordResetSearchUserUI
import com.example.doctour.presentation.model.PasswordResetTokenUI
import com.example.doctour.presentation.model.UserConfirmUI
import com.example.doctour.presentation.model.toPasswordResetNewPasswordUI
import com.example.doctour.presentation.model.toPasswordResetSearchUserUI
import com.example.doctour.presentation.model.toPasswordResetTokenUI
import com.example.doctour.presentation.model.toUserConfirmUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class PasswordViewModel @Inject constructor(
    private val confirmUserUseCase: UserConfirmUseCase,
    private val searchUserAndCreateCodeUseCase: SearchUserAndCreateCodeUseCase,
    private val resetPasswordCodeUseCase: ResetPasswordCodeUseCase,
    private val resetNewPasswordUseCase: ResetNewPasswordUseCase
) : BaseViewModel() {

    private val _confirmUser = MutableUIStateFlow<UserConfirmUI>()
    val confirmUser = _confirmUser.asStateFlow()

    private val _sacCode = mutableUiStateFlow<PasswordResetSearchUserUI>()
    val sacCode = _sacCode.asStateFlow()

    private val _passwordCodeToken = MutableUIStateFlow<PasswordResetTokenUI>()
    val passwordCodeToken = _passwordCodeToken.asStateFlow()

    private val _resetNewPassword = MutableUIStateFlow<PasswordResetNewPasswordUI>()
    val resetNewPassword = _resetNewPassword.asStateFlow()

    private val _code = MutableLiveData<String>()
    val code: LiveData<String> = _code

    fun resetNewPassword(password: String) {
        resetNewPasswordUseCase(
            PasswordResetNewPassword(
                password = password
            ),
            code = _code.value.toString()
        ).collectNetworkRequest(_resetNewPassword) {
            it.toPasswordResetNewPasswordUI()
        }
    }

    fun resetPasswordCodeToken(code: String) {
        resetPasswordCodeUseCase(
            PasswordResetToken(
                code = code
            )
        ).collectNetworkRequest(_passwordCodeToken) {
            it.toPasswordResetTokenUI()
        }

        _code.value = code
    }

    fun searchUserAndCreateCode(phoneNumber: String) {
        searchUserAndCreateCodeUseCase(
            PasswordResetSearchUser(
                phone_number = phoneNumber
            )
        ).collectNetworkRequest(_sacCode) {
            it.toPasswordResetSearchUserUI()
        }
    }

    fun confirmUserCode() {
        confirmUserUseCase(
            UserConfirm(
                code = _code.value?.toInt()
            )
        ).collectNetworkRequest(_confirmUser) {
            it.toUserConfirmUI()
        }
    }

    private val oneSecond = 1000L
    private val time = 55000L
    private val doneTime = 0L
    val currentTime = MutableLiveData<Long>()
    private lateinit var timer: CountDownTimer
    private var _snackBar = MutableLiveData<String>()
    val snackBar: LiveData<String> = _snackBar
    private var text = "Отправлено!"

    init {
        timer = object : CountDownTimer(time, oneSecond) {
            override fun onTick(millisUntilFinished: Long) {
                currentTime.value = millisUntilFinished / oneSecond
            }

            override fun onFinish() {
                currentTime.value = doneTime
                _snackBar.value = text

            }
        }
        timer.start()
    }

    override fun onCleared() {
        super.onCleared()
        timer.cancel()
    }
}