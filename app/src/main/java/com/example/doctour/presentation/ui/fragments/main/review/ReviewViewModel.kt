package com.example.doctour.presentation.ui.fragments.main.review

import androidx.paging.map
import com.example.doctour.base.BaseViewModel
import com.example.doctour.domain.usecases.GetReviewsUseCase
import com.example.doctour.model.toReviewUi
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ReviewViewModel @Inject constructor (
private val getReviewsUseCase: GetReviewsUseCase
): BaseViewModel() {
    fun getReviews() = getReviewsUseCase().collectLocalRequest {
        it.map { review -> review.toReviewUi() }
    }
}