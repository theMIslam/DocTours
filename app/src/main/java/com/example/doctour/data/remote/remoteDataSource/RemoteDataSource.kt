package com.example.doctour.data.remote.remoteDataSource

import com.example.doctour.data.model.AddReviewModel
import com.example.doctour.data.remote.apiService.tours.ToursApiService
import com.example.doctour.data.remote.apiService.user.UserApiService
import com.example.doctour.network.baseDataSource.BaseDataSource
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val apiService: ToursApiService,
    private val userApiService: UserApiService,
) : BaseDataSource() {

    suspend fun getSlugs() = getResult { apiService.getSlugs() }

    suspend fun getTourModelBySlug(slug: String) = getResult { apiService.getTourBySlug(slug) }

    suspend fun getTours(limit: Int) = getResult { apiService.getTours(limit = limit) }

    suspend fun addReview(review: AddReviewModel) = getResult { userApiService.addReview(review) }

    suspend fun addFavorite(slug: String) = getResult { userApiService.addFavorite(slug) }

    suspend fun deleteFavorite(slug: String) = getResult { userApiService.deleteFavorite(slug) }

    suspend fun getFavorites(slug: String) = getResult { apiService.getFavorites(slug) }
}