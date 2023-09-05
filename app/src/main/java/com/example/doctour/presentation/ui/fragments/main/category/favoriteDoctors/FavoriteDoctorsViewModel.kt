package com.example.doctour.presentation.ui.fragments.main.category.favoriteDoctors

import com.example.doctour.base.BaseViewModel
import com.example.doctour.domain.usecases.favorite.favoriteClinics.GetFavoriteClinicsUseCase
import com.example.doctour.domain.usecases.favorite.favoriteDoctors.GetFavoriteDoctorsUseCase
import com.example.doctour.presentation.model.favorite.FavoriteClinicUI
import com.example.doctour.presentation.model.favorite.FavoriteDoctorUI
import com.example.doctour.presentation.model.favorite.toFavoriteClinicUI
import com.example.doctour.presentation.model.favorite.toFavoriteDoctorUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class FavoriteDoctorsViewModel @Inject constructor(
    private val getFavoriteDoctorsUseCase: GetFavoriteDoctorsUseCase,
    private val getFavoriteClinicsUseCase: GetFavoriteClinicsUseCase
):BaseViewModel() {

    private val _getfavDoctor = MutableUIStateFlow<FavoriteDoctorUI>()
    val getfavDoctor = _getfavDoctor.asStateFlow()
    private val _getfavClinic= MutableUIStateFlow<FavoriteClinicUI>()
    val getfavClinic = _getfavClinic.asStateFlow()

    fun getFavoriteDoctors() = getFavoriteDoctorsUseCase().collectPagingRequest {
        it.toFavoriteDoctorUI()
    }

    fun getFavoriteClinics() = getFavoriteClinicsUseCase().collectPagingRequest {
        it.toFavoriteClinicUI()
    }


}