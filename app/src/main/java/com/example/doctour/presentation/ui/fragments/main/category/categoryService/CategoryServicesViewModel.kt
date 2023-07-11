package com.example.doctour.presentation.ui.fragments.main.category.categoryService

import com.example.doctour.base.BaseViewModel
import com.example.doctour.domain.usecases.GetCategoryServiceUseCase
import com.example.doctour.presentation.model.toServiceUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class CategoryServicesViewModel @Inject constructor(
    private val getCategoryServiceUseCase: GetCategoryServiceUseCase
) : BaseViewModel() {

    private val _name = MutableStateFlow<String?>(null)
    val name = _name.asStateFlow()

    private val _price = MutableStateFlow<String?>(null)
    val price= _price.asStateFlow()

    private val _search = MutableStateFlow<String?>(null)
    val search = _search.asStateFlow()

    fun getServiceOfDoctors() = getCategoryServiceUseCase(
        _name.value,
        _price.value,
        _search.value
    ).collectPagingRequest {
        it.toServiceUi()
    }
    fun  x (name: String){
        _name.value = name
    }

}