package com.example.doctour.data.remote.pagingsources.favorite

import com.example.doctour.data.base.BasePagingSource
import com.example.doctour.data.model.favoriteClinic.FavoriteClinicDt
import com.example.doctour.data.remote.apiservices.DoctourApiService
import com.example.doctour.domain.model.favoriteClinics.FavoriteClinic

class FavoriteClinicsPagingSource (
    private val doctourApiService: DoctourApiService
        ):BasePagingSource<FavoriteClinicDt, FavoriteClinic>({ page ->
            doctourApiService.getFavoriteClinics(page)
})