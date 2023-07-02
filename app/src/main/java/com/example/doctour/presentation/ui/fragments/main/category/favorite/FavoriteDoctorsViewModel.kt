package com.example.doctour.presentation.ui.fragments.main.category.favorite

import com.example.doctour.base.BaseViewModel
import com.example.doctour.domain.usecases.GetAllDoctorsUseCase
import com.example.doctour.model.DoctorUi
import com.example.doctour.model.toDoctorUi
import com.example.doctour.presentation.ui.state.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class FavoriteDoctorsViewModel @Inject constructor(

):BaseViewModel() {

}