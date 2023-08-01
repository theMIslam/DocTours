package com.example.doctour.presentation.ui.fragments.splash

import com.example.doctour.base.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SplashScreenViewModel @Inject constructor(
) : BaseViewModel() {

    val delayMills = 2000

}