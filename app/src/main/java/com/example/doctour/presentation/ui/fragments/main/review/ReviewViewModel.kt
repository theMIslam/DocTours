package com.example.doctour.presentation.ui.fragments.main.review

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.map
import com.example.doctour.base.BaseViewModel
import com.example.doctour.domain.usecases.GetReviewsUseCase
import com.example.doctour.domain.usecases.WriteReviewUseCase
import com.example.doctour.presentation.model.ReviewBodyUI
import com.example.doctour.presentation.model.ReviewUI
import com.example.doctour.presentation.model.toReviewBody
import com.example.doctour.presentation.model.toReviewUI
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ReviewViewModel @Inject constructor (
private val getReviewsUseCase: GetReviewsUseCase,
private val writeReviewUseCase: WriteReviewUseCase
): BaseViewModel() {

    private val _writeReview = MutableUIStateFlow<ReviewUI>()
    val writeReview = _writeReview.asStateFlow()

    private val _user = MutableLiveData<ReviewUI>()
    val user:LiveData<ReviewUI> = _user

    fun writeReview(reviewBody: ReviewBodyUI) = writeReviewUseCase(
        reviewBody.toReviewBody()
    ).collectNetworkRequest(_writeReview){
        it.toReviewUI()
    }

    fun getReviews() = getReviewsUseCase().collectLocalRequest {
        it.map { review -> review.toReviewUI() }
    }
}