package com.example.doctour.presentation.ui.fragments.main.category.doctorCategory

import com.example.doctour.base.BaseViewModel
import com.example.doctour.domain.usecases.GetCategoryDoctorsUseCase
import com.example.doctour.presentation.model.toSpecialityUi
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CategoryDoctorsViewModel @Inject constructor(
    private val getCategoryUseCase:GetCategoryDoctorsUseCase
) :BaseViewModel(){

    fun getSpecialityOfDoctors()=getCategoryUseCase().collectPagingRequest { it.toSpecialityUi() }

}