package com.example.doctour.data.remote.pagingSources

import com.example.doctour.data.base.BasePagingSource
import com.example.doctour.data.model.FilterModel
import com.example.doctour.data.model.ShortDoctourModel
import com.example.doctour.data.model.ShortDoctourResponse
import com.example.doctour.data.remote.apiService.tours.PagingApiService

class DoctorsPagingSource(private val apiService: PagingApiService, filter: FilterModel) :
    BasePagingSource<ShortDoctourResponse, ShortDoctourModel>({
        apiService.getFilteredTours(
            it,
            category = filter.category,
            date_departure = filter.date_departure,
            complexity = filter.complexity,
            duration = filter.duration,
            price_max = filter.price_max,
        )
    })