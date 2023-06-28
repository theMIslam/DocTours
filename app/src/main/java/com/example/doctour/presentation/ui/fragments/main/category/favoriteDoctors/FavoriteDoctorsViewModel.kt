package com.example.doctour.presentation.ui.fragments.main.category.favoriteDoctors

import com.example.doctour.base.BaseViewModel
import com.example.doctour.domain.usecases.GetAllDoctorsUseCase
import com.example.doctour.presentation.model.toDoctorUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class FavoriteDoctorsViewModel @Inject constructor(
    private val getAllDoctorsUseCase: GetAllDoctorsUseCase
):BaseViewModel() {
    private val _speciality = MutableStateFlow<String?>(null)
    val speciality = _speciality.asStateFlow()

    private val _clinic = MutableStateFlow<String?>(null)
    val clinic = _clinic.asStateFlow()

    private val _category = MutableStateFlow<String?>(null)
    val category = _category.asStateFlow()

    private val _city = MutableStateFlow<String?>(null)
    val city = _city.asStateFlow()
    private val _search = MutableStateFlow<String?>(null)
    val search = _search.asStateFlow()

    private val _ordering = MutableStateFlow<String?>(null)
    val ordering = _ordering.asStateFlow()

    fun getAllFavoriteDoctors() = getAllDoctorsUseCase(
        _speciality.value,
        _clinic.value,
        _category.value,
        _city.value,
        _search.value,
        _ordering.value
    ).collectPagingRequest { it.toDoctorUi() }
}