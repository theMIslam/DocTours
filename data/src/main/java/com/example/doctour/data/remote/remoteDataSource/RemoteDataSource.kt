package com.example.doctour.data.remote.remoteDataSource

import com.example.doctour.data.remote.apiService.tours.DoctorsApiService
import com.example.doctour.data.network.baseDataSource.BaseDataSource
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val apiService: DoctorsApiService) : BaseDataSource() {

    suspend fun getSlugs() = getResult { apiService.getSlugs() }

    suspend fun getTourModelBySlug(slug: String) = getResult { apiService.getTourBySlug(slug) }

    suspend fun getTours(limit: Int) = getResult { apiService.getTours(limit = limit) }
}