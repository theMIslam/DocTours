package com.example.doctour.data.remote.pagingsources.review

import com.example.doctour.data.base.BasePagingSource
import com.example.doctour.data.model.ReviewDt
import com.example.doctour.data.remote.apiservices.DoctourApiService
import com.example.doctour.domain.model.reviews.Review

class ReviewsPagingSource(
    private val doctourApiService: DoctourApiService
) : BasePagingSource<ReviewDt, Review>({ page ->
    doctourApiService.getReviews(page)
})