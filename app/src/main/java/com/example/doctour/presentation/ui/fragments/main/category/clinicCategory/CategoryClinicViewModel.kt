package com.example.doctour.presentation.ui.fragments.main.category.clinicCategory

import com.example.doctour.base.BaseViewModel
import com.example.doctour.domain.usecases.GetClinicUseCase
import com.example.doctour.model.toClinicsUi
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CategoryClinicViewModel @Inject constructor(
    private val getCategoryClinicUseCase: GetClinicUseCase
) :BaseViewModel(){

    fun getClinic()
    =getCategoryClinicUseCase().collectPagingRequest {
        it.toClinicsUi()
    }
}