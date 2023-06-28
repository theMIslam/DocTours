package com.example.doctour.data.remote.pagingsources

import com.example.doctour.data.base.BasePagingSource
import com.example.doctour.data.model.ReviewDt
import com.example.doctour.data.remote.apiservices.DoctourApiService
import com.example.doctour.domain.model.Review

class ReviewsPagingSource(
    private val doctourApiService: DoctourApiService
) : BasePagingSource<ReviewDt, Review>({
    doctourApiService.getReviews(it)
})