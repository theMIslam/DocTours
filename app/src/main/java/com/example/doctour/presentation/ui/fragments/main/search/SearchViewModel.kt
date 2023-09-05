package com.example.doctour.presentation.ui.fragments.main.search

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.doctour.base.BaseViewModel
import com.example.doctour.domain.usecases.search.SearchUseCase
import com.example.doctour.presentation.model.doctour.toDoctorUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.flatMapLatest
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase
) : BaseViewModel() {

    private val _getSearch = MutableStateFlow("")
    val getSearch = _getSearch.asStateFlow()

    private val _count = MutableLiveData<Int>()
    val count:LiveData<Int> = _count

    val doc = _getSearch.flatMapLatest { string ->
        searchUseCase.invoke(string).collectPagingRequest { it.toDoctorUI() }
    }
    fun searchBy(query: String) {
        _getSearch.value = query
    }

    fun setItemAmount (count:Int){
        _count.value = count
    }

}