package com.example.doctour.presentation.ui.fragments.main.category

import com.example.doctour.domain.usecases.GetAllDoctorsUseCase
import com.example.doctour.base.BaseViewModel
import com.example.doctour.presentation.model.toDoctorUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel  @Inject constructor(
): BaseViewModel(){
}