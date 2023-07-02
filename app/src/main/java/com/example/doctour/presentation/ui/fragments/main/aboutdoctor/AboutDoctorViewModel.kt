package com.example.doctour.presentation.ui.fragments.main.aboutdoctor

import androidx.lifecycle.MutableLiveData
import com.example.doctour.base.BaseViewModel
import com.example.doctour.domain.model.Doctor
import com.example.doctour.domain.usecases.local.CreateFavDoctorUseCase
import com.example.doctour.model.DoctorUi
import com.example.doctour.presentation.ui.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class AboutDoctorViewModel @Inject constructor(
    //private val createFavDoctorUseCase: CreateFavDoctorUseCase
)
    : BaseViewModel() {

    private val _createFav = MutableStateFlow<UIState<Unit>>(UIState.Idle())
    val createFav = _createFav.asStateFlow()

    val loading = MutableLiveData<Boolean>()

    fun addFavoriteDoctor(doctorUi:DoctorUi) {
        //createFavDoctorUseCase.createFavoriteDoctors(doctorUi).collectData(_createFav)
    }

}