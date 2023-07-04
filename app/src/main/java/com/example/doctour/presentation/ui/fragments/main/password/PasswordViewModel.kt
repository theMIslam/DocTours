package com.example.doctour.presentation.ui.fragments.main.password

import android.os.CountDownTimer
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.doctour.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PasswordViewModel @Inject constructor (
): BaseViewModel() {
    private val oneSecond = 1000L
    private val time= 55000L
    private val doneTime = 0L
    val currentTime = MutableLiveData<Long>()
    private lateinit var timer :CountDownTimer
    private var _snackBar = MutableLiveData<String>()
    val snackBar : LiveData<String> = _snackBar
    private  var text = "Отправлено!"

    init {
        timer = object :CountDownTimer(time,oneSecond){
            override fun onTick(millisUntilFinished: Long) {
                currentTime.value = millisUntilFinished/oneSecond
            }

            override fun onFinish() {
               currentTime.value = doneTime
                _snackBar.value= text

            }
        }
        timer.start()
    }

    override fun onCleared() {
        super.onCleared()
        timer.cancel()
    }
}