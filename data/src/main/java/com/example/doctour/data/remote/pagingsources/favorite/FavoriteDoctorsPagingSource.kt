package com.example.doctour.data.remote.pagingsources.favorite

import com.example.doctour.data.base.BasePagingSource
import com.example.doctour.data.model.FavoriteDoctorDt
import com.example.doctour.data.remote.apiservices.DoctourApiService
import com.example.doctour.domain.model.favoriteDoctors.FavoriteDoctor

class FavoriteDoctorsPagingSource (
    private val doctourApiService: DoctourApiService
        ):BasePagingSource<FavoriteDoctorDt, FavoriteDoctor>({ page ->
            doctourApiService.getFavoriteDoctors(page)
})