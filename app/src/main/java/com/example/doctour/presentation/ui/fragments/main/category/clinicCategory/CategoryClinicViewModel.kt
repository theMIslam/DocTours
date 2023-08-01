package com.example.doctour.presentation.ui.fragments.main.category.clinicCategory

import com.example.doctour.base.BaseViewModel
import com.example.doctour.domain.usecases.GetClinicUseCase
import com.example.doctour.presentation.model.toClinicUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CategoryClinicViewModel @Inject constructor(
    private val getCategoryClinicUseCase: GetClinicUseCase
) :BaseViewModel(){

    private val _search = MutableStateFlow<String>("")
    val search = _search.asStateFlow()

    private val _subService = MutableStateFlow<String>("")
    val subService = _subService.asStateFlow()

    private val _city = MutableStateFlow<String>("")
    val city = _city.asStateFlow()

    fun getClinic()
    =getCategoryClinicUseCase(
        _search.value,
        _subService.value,
        _city.value
    ).collectPagingRequest {
        it.toClinicUI()
    }
}