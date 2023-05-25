package com.example.doctour.data.repository.tours

import androidx.paging.PagingData
import com.example.doctour.data.base.BaseRepository
import com.example.doctour.data.model.FilterModel
import com.example.doctour.data.model.ShortTourModel
import com.example.doctour.data.remote.apiService.tours.PagingApiService
import com.example.doctour.data.remote.pagingSources.ToursPagingSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FilteredToursRepository @Inject constructor(private val apiService: PagingApiService) :
    BaseRepository() {

    fun getFilteredTours(filter: FilterModel): Flow<PagingData<ShortTourModel>> {
        return doPagingRequest(ToursPagingSource(apiService, filter), pageSize = 10)
    }
}