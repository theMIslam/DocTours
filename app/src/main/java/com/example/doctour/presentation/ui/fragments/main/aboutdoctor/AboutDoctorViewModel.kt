package com.example.doctour.presentation.ui.fragments.main.aboutdoctor

import androidx.lifecycle.MutableLiveData
import com.example.doctour.base.BaseViewModel
import com.example.doctour.common.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AboutDoctorViewModel @Inject constructor(

): BaseViewModel() {

    private val _createFav = MutableStateFlow<UIState<Unit>>(UIState.Idle())
    val createFav = _createFav.asStateFlow()

    val loading = MutableLiveData<Boolean>()

}