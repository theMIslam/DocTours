package com.example.doctour.presentation.ui.fragments.main.review

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.map
import com.example.doctour.base.BaseViewModel
import com.example.doctour.domain.model.Review
import com.example.doctour.domain.model.WriteReview
import com.example.doctour.domain.usecases.GetReviewsUseCase
import com.example.doctour.domain.usecases.WriteReviewUseCase
import com.example.doctour.presentation.model.ReviewUi
import com.example.doctour.presentation.model.toReviewUi
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ReviewViewModel @Inject constructor (
private val getReviewsUseCase: GetReviewsUseCase,
private val writeReviewUseCase: WriteReviewUseCase
): BaseViewModel() {

    private val _writeReview = MutableUIStateFlow<ReviewUi>()
    val writeReview = _writeReview.asStateFlow()

    private val _user = MutableLiveData<ReviewUi>()
    val user:LiveData<ReviewUi> = _user

    fun writeReview(review: WriteReview) = writeReviewUseCase(review).collectRequest(_writeReview){
        it.toReviewUi()
    }

    fun getReviews() = getReviewsUseCase().collectLocalRequest {
        it.map { review -> review.toReviewUi() }
    }
}