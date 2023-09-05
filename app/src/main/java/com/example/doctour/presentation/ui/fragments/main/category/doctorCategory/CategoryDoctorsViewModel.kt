package com.example.doctour.presentation.ui.fragments.main.category.doctorCategory

import com.example.doctour.base.BaseViewModel
import com.example.doctour.domain.usecases.category.categoryDoctors.GetCategoryDoctorsUseCase
import com.example.doctour.presentation.model.speciality.toSpecialtyUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CategoryDoctorsViewModel @Inject constructor(
    private val getCategoryUseCase: GetCategoryDoctorsUseCase
) :BaseViewModel(){

    private val _search = MutableStateFlow<String>("")
    val search = _search.asStateFlow()
    fun getSpecialityOfDoctors()=getCategoryUseCase(
        _search.value
    ).collectPagingRequest { it.toSpecialtyUI() }

}