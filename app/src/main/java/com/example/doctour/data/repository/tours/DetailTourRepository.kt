package com.example.doctour.data.repository.tours

import com.example.doctour.data.base.BaseRepository
import com.example.doctour.data.remote.apiService.tours.PagingApiService
import com.example.doctour.data.remote.pagingSources.ReviewPagingSource
import com.example.doctour.data.remote.remoteDataSource.RemoteDataSource
import javax.inject.Inject

class DetailTourRepository @Inject constructor(
    private val dataSource: RemoteDataSource,
    private val apiService: PagingApiService,
) : BaseRepository() {

    fun getTourBySlug(slug: String) = doRequest { dataSource.getTourModelBySlug(slug) }

    fun getReviewsBySlug(slug: String) =
        doPagingRequest(ReviewPagingSource(apiService, slug = slug), pageSize = 10)

    fun addFavorite(slug: String) = doRequest { dataSource.addFavorite(slug) }

    fun deleteFavorite(slug: String) = doRequest { dataSource.deleteFavorite(slug) }

    fun getFavorites(slug: String) = doRequest { dataSource.getFavorites(slug) }
}