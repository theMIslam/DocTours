package com.example.doctour.data.remote.pagingSources

import com.example.doctour.data.model.FilterModel
import com.example.doctour.data.model.ShortTourModel
import com.example.doctour.data.model.ShortTourResponse
import com.example.doctour.data.remote.apiService.tours.PagingApiService
import com.example.doctour.network.paging.BasePagingSource

class ToursPagingSource(private val apiService: PagingApiService, filter: FilterModel) :
    BasePagingSource<ShortTourResponse, ShortTourModel>({
        apiService.getFilteredTours(
            it,
            category = filter.category,
            date_departure = filter.date_departure,
            complexity = filter.complexity,
            duration = filter.duration,
            price_max = filter.price_max,
        )
    })