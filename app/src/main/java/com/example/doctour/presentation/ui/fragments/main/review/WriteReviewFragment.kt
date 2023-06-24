package com.example.doctour.presentation.ui.fragments.main.review

import android.graphics.Color
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.doctour.R
import com.example.doctour.base.BaseFragment
import com.example.doctour.databinding.FragmentWriteReviewBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class WriteReviewFragment : BaseFragment<FragmentWriteReviewBinding, ReviewViewModel>(
    R.layout.fragment_write_review
) {

    override val binding: FragmentWriteReviewBinding by viewBinding(FragmentWriteReviewBinding::bind)
    override val viewModel: ReviewViewModel by viewModels<ReviewViewModel>()


    override fun initListeners() {
        super.initListeners()
        clickers()
    }

    private fun clickers() {
        if (binding.etYourReview.text!!.isNotEmpty()) {
            binding.btnLeaveFeedback.background.setTint(Color.parseColor("#1B6B93"))
        }else {
//            showToast("Напишите отзыв")
        }

        binding.btnLeaveFeedback.setOnClickListener {
            sendReview()
        }
    }

    private fun sendReview() {

    }
}