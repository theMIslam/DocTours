package com.example.doctour.presentation.ui.fragments.home


import com.example.doctour.base.BaseViewModel
import com.example.doctour.domain.usecases.GetDoctorsUseCase
import com.example.doctour.domain.usecases.GetCategoryDoctorsUseCase
import com.example.doctour.domain.usecases.GetClinicUseCase
import com.example.doctour.presentation.model.DoctorUI
import com.example.doctour.presentation.model.toClinicUI
import com.example.doctour.presentation.model.toDoctorUI
import com.example.doctour.presentation.model.toSpecialtyUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllDoctorsUseCase: GetDoctorsUseCase,
    private val  getDoctorSpeciality: GetCategoryDoctorsUseCase,
    private  val getClinicUseCase: GetClinicUseCase
) : BaseViewModel() {

    private val _doctorUiState = MutableUIStateFlow<DoctorUI>()
    val doctorUIState = _doctorUiState.asStateFlow()

    private val _speciality = MutableStateFlow<String?>(null)
    val speciality = _speciality.asStateFlow()

    private val _clinic = MutableStateFlow<String>("")
    val clinic = _clinic.asStateFlow()

    private val _category = MutableStateFlow<String?>(null)
    val category = _category.asStateFlow()

    private val _city = MutableStateFlow<String>("")
    val city = _city.asStateFlow()
    private val _search = MutableStateFlow<String>("")
    val search = _search.asStateFlow()

    private val _ordering = MutableStateFlow<String?>(null)
    val ordering = _ordering.asStateFlow()

    fun getALlDoctors() = getAllDoctorsUseCase(
        _speciality.value,
        _category.value,
        _city.value,
        _search.value,
        _ordering.value
    ).collectPagingRequest { it.toDoctorUI() }

    fun getTheBestDoctorSpeciality () = getDoctorSpeciality(
        _search.value
    ).collectPagingRequest { it.toSpecialtyUI() }

    fun getTheBestClinics() = getClinicUseCase(
        _search.value,
        _clinic.value,
        _city.value
    ).collectPagingRequest { it.toClinicUI() }

}