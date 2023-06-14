package com.example.doctour.data.remote.pagingSources

import com.example.doctour.data.model.ReviewModel
import com.example.doctour.data.model.ReviewResponse
import com.example.doctour.data.remote.apiService.tours.PagingApiService
import com.example.doctour.data.network.paging.BasePagingSource

class ReviewPagingSource(private val apiService: PagingApiService, slug: String) :
    BasePagingSource<ReviewResponse, ReviewModel>({
        apiService.getReviewsBySlug(
            slug = slug,
            it,
        )
    })