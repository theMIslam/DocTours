package com.example.doctour.data.repositories

import androidx.paging.PagingData
import com.example.doctour.data.base.BaseRepository
import com.example.doctour.data.model.FilterModel
import com.example.doctour.data.model.ShortDoctourModel
import com.example.doctour.data.remote.apiService.tours.PagingApiService
import com.example.doctour.data.remote.pagingSources.DoctorsPagingSource
import com.example.doctour.data.remote.remoteDataSource.RemoteDataSource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val dataSource: RemoteDataSource,
    private val apiService: PagingApiService,
) : BaseRepository() {

    fun getTours(limit: Int) =
        doRequest { dataSource.getTours(limit = limit) }

    fun getCategoryTours(category: String): Flow<PagingData<ShortDoctourModel>> {
        return doPagingRequest(DoctorsPagingSource(apiService, FilterModel(category)), pageSize = 10)
    }
}