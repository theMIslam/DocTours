package com.example.doctour.data.repository.post

import com.example.doctour.data.base.BaseRepository
import com.example.doctour.data.model.AddReviewModel
import com.example.doctour.data.remote.remoteDataSource.RemoteDataSource
import javax.inject.Inject

class AddReviewRepository @Inject constructor(
    private val dataSource: RemoteDataSource,
) : BaseRepository() {

    fun addReview(review: AddReviewModel) = doRequest { dataSource.addReview(review) }
}